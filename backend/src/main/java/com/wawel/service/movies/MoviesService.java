package com.wawel.service.movies;

import com.wawel.common.*;
import com.wawel.entity.auth.User;
import com.wawel.entity.cinema.Ticket;
import com.wawel.entity.movies.Movie;
import com.wawel.entity.movies.Screening;
import com.wawel.persistence.repositories.*;
import com.wawel.persistence.repositories.auth.UsersRepository;
import com.wawel.request.*;
import com.wawel.response.*;
import com.wawel.service.mapper.MoviesMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private ScreeningsRepository screeningsRepository;

    public List<GeneralMovieResponse> getMovies() {
        return moviesRepository.findAll().stream()
                .map(MoviesMapper::toMovieResponse)
                .toList();
    }

    public GeneralMovieResponse getMovie(final Long movieId) {
        return MoviesMapper.toMovieResponse(moviesRepository.findById(movieId).orElseThrow());
    }

    public Movie addMovie(final AddMovieRequest request) {
        return moviesRepository.save(Movie.builder()
                .title(request.getTitle())
                .genre(request.getGenre())
                .minAge(request.getMinAge())
                .duration(request.getDuration())
                .posterSource(request.getPosterSource().getBytes(StandardCharsets.UTF_8))
                .bigImageSource(request.getBigImageSource().getBytes(StandardCharsets.UTF_8))
                .trailerSource(request.getTrailerSource())
                .status(Status.BRAK_SEANSU)
                .description(request.getDescription())
                .reviews(new ArrayList<>())
                .screenings(new ArrayList<>())
                .build());
    }

    public ResponseEntity<String> deleteMovie(final Long movieId) {
        Optional<Movie> toDelete = moviesRepository.findById(movieId);
        if (toDelete.isEmpty()) {
            return new ResponseEntity<>("Nie znaleziono filmu o podanym id", HttpStatus.NOT_FOUND);
        }
        moviesRepository.delete(toDelete.get());
        return new ResponseEntity<>("Pomyślnie usunięto film", HttpStatus.OK);
    }

    public ResponseEntity<String> archiveMovie(Long movieId) {
        Movie movie = moviesRepository.findById(movieId).orElseThrow();
        movie.setStatus(Status.ZARCHIWIZOWANY);
        moviesRepository.save(movie);

        return new ResponseEntity<>("Pomyślnie zarchiwizowano film", HttpStatus.OK);
    }

    public ResponseEntity<String> editMovie(EditMovieRequest request) {
        Optional<Movie> movie = moviesRepository.findById(request.getMovieId());
        if (movie.isEmpty()) {
            return new ResponseEntity<>("Film o podanym id nie istnieje", HttpStatus.BAD_REQUEST);
        }
        Movie movieEntity = movie.get();
        movieEntity.setTitle(request.getTitle());
        movieEntity.setGenre(request.getGenre());
        movieEntity.setMinAge(request.getMinAge());
        movieEntity.setDuration(request.getDuration());
        movieEntity.setPosterSource(request.getPosterSource().getBytes(StandardCharsets.UTF_8));
        movieEntity.setBigImageSource(request.getBigImageSource().getBytes(StandardCharsets.UTF_8));
        movieEntity.setTrailerSource(request.getTrailerSource());
        movieEntity.setDescription(request.getDescription());

        moviesRepository.save(movieEntity);
        return new ResponseEntity<>("Pomyślnie edytowano film", HttpStatus.OK);
    }

    public ResponseEntity<String> buyTickets(BuyTicketsRequest request) {
        for (BuyTicketInfo ticket : request.getTickets()) {
            Screening screening = screeningsRepository.findById(request.getScreeningId()).orElseThrow();
            String[][] seats = screening.getSeats();
            if (screening.getRepertoire().getDate().isBefore(LocalDate.now())) {
                return new ResponseEntity<>("Seans już się odbył", HttpStatus.BAD_REQUEST);
            }

            if (seats[ticket.getSeatRow()][ticket.getSeatNumber()].equals(Availability.ZAJETE.name())
                    || seats[ticket.getSeatRow()][ticket.getSeatNumber()].equals(Availability.NIE_ISTNIEJE.name())) {
                return new ResponseEntity<>(
                        "Miejsce: [" + ticket.getSeatRow() + "][" + ticket.getSeatNumber() + "] zajęte bądź nie istnieje",
                        HttpStatus.BAD_REQUEST);
            }


            screening.changeSeatStatus(ticket.getSeatRow(), ticket.getSeatNumber());

            Ticket ticketEntity;

            if (request.getUserId() != null) {
                User user = usersRepository.findById(request.getUserId()).orElseThrow();

                ticketEntity = Ticket.builder()
                        .user(user)
                        .screening(screening)
                        .seatRow(ticket.getSeatRow())
                        .seatNumber(ticket.getSeatNumber())
                        .ticketType(ticket.getTicketType())
                        .build();
            } else {
                ticketEntity = Ticket.builder()
                        .user(null)
                        .screening(screening)
                        .seatRow(ticket.getSeatRow())
                        .seatNumber(ticket.getSeatNumber())
                        .ticketType(ticket.getTicketType())
                        .build();
            }


            ticketsRepository.save(ticketEntity);
        }
        return new ResponseEntity<>("Pomyślnie zakupiono biliety", HttpStatus.OK);
    }

    public GetUserInfoResponse getUserInfo(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow();
        List<TicketsByScreeningResponse> groupedTickets = new ArrayList<>();
        Map<Long, TicketsByScreeningResponse> screeningIdToGroupedTickets = new HashMap<>();
        for (Ticket ticket : user.getTickets()) {
            Long screeningId = ticket.getScreening().getId();
            if (!screeningIdToGroupedTickets.containsKey(screeningId)) {
                screeningIdToGroupedTickets.put(screeningId, TicketsByScreeningResponse.builder()
                        .screeningId(screeningId)
                        .city(ticket.getScreening().getRepertoire().getCinema().getCity())
                        .date(ticket.getScreening().getRepertoire().getDate())
                        .startTime(ticket.getScreening().getStartTime())
                        .movieTitle(ticket.getScreening().getMovie().getTitle())
                        .movieId(ticket.getScreening().getMovie().getId())
                        .screenName(ticket.getScreening().getScreen().getScreenName())
                        .tickets(List.of(MoviesMapper.toTicketResponse(ticket)))
                        .build());
            } else {

                TicketsByScreeningResponse updatedTicket=  new TicketsByScreeningResponse(screeningIdToGroupedTickets.get(screeningId));
                updatedTicket.addTicket(MoviesMapper.toTicketResponse(ticket));

                screeningIdToGroupedTickets.replace(screeningId, updatedTicket);
            }
        }

        for (Map.Entry<Long, TicketsByScreeningResponse> entry : screeningIdToGroupedTickets.entrySet()) {
            groupedTickets.add(entry.getValue());
        }

        return GetUserInfoResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles())
                .tickets(groupedTickets)
                .reviews(user.getReviews().stream().map(MoviesMapper::toMovieReviewResponse).toList())
                .watchedMovies(user.getWatchedMovies())
                .build();
    }
}
