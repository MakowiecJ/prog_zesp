package com.wawel.service.movies;

import com.wawel.common.*;
import com.wawel.entity.auth.User;
import com.wawel.entity.cinema.Cinema;
import com.wawel.entity.cinema.Screen;
import com.wawel.entity.cinema.Ticket;
import com.wawel.entity.movies.Movie;
import com.wawel.entity.movies.Repertoire;
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

    @Autowired
    private CinemaRepository cinemasRepository;

    @Autowired
    private ScreensRepository screensRepository;

    @Autowired
    private RepertoireRepository repertoireRepository;

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
            return new ResponseEntity<>("Movie with id: " + movieId + " does not exist", HttpStatus.NOT_FOUND);
        }
        moviesRepository.delete(toDelete.get());
        return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> archiveMovie(Long movieId) {
        Movie movie = moviesRepository.findById(movieId).orElseThrow();
        movie.setStatus(Status.ZARCHIWIZOWANY);
        moviesRepository.save(movie);

        return new ResponseEntity<>("Movie archived successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> editMovie(EditMovieRequest request) {
        Optional<Movie> movie = moviesRepository.findById(request.getMovieId());
        if (movie.isEmpty()) {
            return new ResponseEntity<>("Movie with id: " + request.getMovieId() + " does not exist", HttpStatus.BAD_REQUEST);
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
        return new ResponseEntity<>("Movie edited successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> buyTickets(BuyTicketsRequest request) {
        for (BuyTicketInfo ticket : request.getTickets()) {
            Screening screening = screeningsRepository.findById(request.getScreeningId()).orElseThrow();
            String[][] seats = screening.getSeats();
            if (screening.getRepertoire().getDate().isBefore(LocalDate.now())) {
                return new ResponseEntity<>("Screening has already been played", HttpStatus.BAD_REQUEST);
            }

            if (seats[ticket.getSeatRow()][ticket.getSeatNumber()].equals(Availability.ZAJETE.name())
                    || seats[ticket.getSeatRow()][ticket.getSeatNumber()].equals(Availability.NIE_ISTNIEJE.name())) {
                return new ResponseEntity<>(
                        "Seat: [" + ticket.getSeatRow() + "][" + ticket.getSeatNumber() + "] is taken",
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
        return new ResponseEntity<>("Tickets bought successfully", HttpStatus.OK);
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
                .watchedMovies(user.getWatchedMovies())
                .build();
    }

    public GetScreeningResponse getScreening(final Long screeningId) {
        Screening screening = screeningsRepository.findById(screeningId).orElseThrow();
        return GetScreeningResponse.builder()
                .screenId(screeningId)
                .movieId(screening.getMovie().getId())
                .repertoireId(screening.getRepertoire().getId())
                .date(screening.getRepertoire().getDate())
                .startTime(screening.getStartTime())
                .movieType(screening.getMovieType())
                .movieSoundType(screening.getMovieSoundType())
                .seats(screening.getSeats())
                .build();
    }

    public ResponseEntity<String> addScreening(AddScreeningRequest request) {
        Movie movie = moviesRepository.findById(request.getMovieId()).orElseThrow();

        if (movie.getStatus().equals(Status.ZARCHIWIZOWANY)) {
            return new ResponseEntity<>("The movie with id: " + request.getMovieId() + " is archived", HttpStatus.BAD_REQUEST);
        }

        Cinema cinema = cinemasRepository.findByCity(request.getCity());
        Screen screen = screensRepository.findByCinemaIdAndScreenName(cinema.getId(), request.getScreenName());
        Optional<Repertoire> repertoire = repertoireRepository.findByCinemaAndDate(cinema, request.getDate());

        if (repertoire.isEmpty()) {
            Repertoire newRepertoire = repertoireRepository.save(Repertoire.builder()
                    .cinema(cinema)
                    .date(request.getDate())
                    .build());

            Screening screening = Screening.builder()
                    .screen(screen)
                    .movie(movie)
                    .repertoire(newRepertoire)
                    .startTime(request.getStartTime())
                    .movieType(request.getMovieType())
                    .movieSoundType(request.getMovieSoundType())
                    .seats(Screening.newSeats())
                    .build();

            screeningsRepository.save(screening);

        } else {
            Screening screening = Screening.builder()
                    .screen(screen)
                    .movie(movie)
                    .repertoire(repertoire.get())
                    .startTime(request.getStartTime())
                    .movieType(request.getMovieType())
                    .movieSoundType(request.getMovieSoundType())
                    .seats(Screening.newSeats())
                    .build();

            screeningsRepository.save(screening);
        }

        return null;
    }

    public ResponseEntity<?> editScreening(final EditScreeningRequest request, final City city, final LocalDate date) {

        if (request.getScreeningId() == null || screeningsRepository.findById(request.getScreeningId()).isEmpty()) {
            addScreening(AddScreeningRequest.builder()
                    .city(city)
                    .screenName(request.getScreenName())
                    .movieId(request.getMovieId())
                    .date(date)
                    .startTime(request.getStartTime())
                    .movieType(request.getMovieType())
                    .movieSoundType(request.getMovieSoundType())
                    .build());
            return new ResponseEntity<>("Screening added successfully", HttpStatus.OK);
        }
        Optional<Screening> screening = screeningsRepository.findById(request.getScreeningId());

        Screening screeningEntity = screening.get();

        Cinema cinema = screeningEntity.getRepertoire().getCinema();
        Screen screen = screensRepository.findByCinemaIdAndScreenName(cinema.getId(), request.getScreenName());
        Optional<Movie> movie = moviesRepository.findById(request.getMovieId());
        if (movie.isEmpty()) {
            return new ResponseEntity<>("Movie with id:" + request.getMovieId() + " not found", HttpStatus.NOT_FOUND);
        }

        screeningEntity.setScreen(screen);
        screeningEntity.setMovie(movie.get());
        screeningEntity.setStartTime(request.getStartTime());
        screeningEntity.setMovieType(request.getMovieType());
        screeningEntity.setMovieSoundType(request.getMovieSoundType());

        screeningsRepository.save(screeningEntity);

        return new ResponseEntity<>("Screening edited successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteScreening(Long screeningId) {
        Optional<Screening> screening = screeningsRepository.findById(screeningId);
        if (screening.isEmpty()) {
            return new ResponseEntity<>("Screening with id: " + screeningId + " not found", HttpStatus.NOT_FOUND);
        }
        screeningsRepository.delete(screening.get());
        return new ResponseEntity<>("Screening deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity<?> getRepertoire(GetRepertoireRequest request) {
        Cinema cinema = cinemasRepository.findByCity(request.getCity());
        Optional<Repertoire> repertoire = repertoireRepository.findByCinemaAndDate(cinema, request.getDate());

        if (repertoire.isEmpty()) {
            return new ResponseEntity<>(addRepertoire(AddRepertoireRequest.of(request.getCity(), request.getDate())), HttpStatus.OK);
        }

        List<RepertoireItem> items = new ArrayList<>();

        List<Long> movieIds = new ArrayList<>();
        Map<Long, GeneralMovieResponse> idToMovie = new HashMap<>();
        Map<Long, List<ScreeningItem>> screeningToMovie = new HashMap<>();


        if (repertoire.get().getScreenings() != null) {
            for (Screening screening : repertoire.get().getScreenings()) {
                if (screening.getRepertoire().getDate().equals(request.getDate())) {
                    if (!movieIds.contains(screening.getMovie().getId())) {
                        movieIds.add(screening.getMovie().getId());
                        idToMovie.put(screening.getMovie().getId(), MoviesMapper.toMovieResponse(screening.getMovie()));

                        screeningToMovie.put(screening.getMovie().getId(), List.of(ScreeningItem.builder()
                                .screeningId(screening.getId())
                                .startTime(screening.getStartTime())
                                .screenName(screening.getScreen().getScreenName())
                                .movieType(screening.getMovieType())
                                .movieSoundType(screening.getMovieSoundType())
                                .build()));
                    } else {
                        List<ScreeningItem> screeningItems = new ArrayList<>(screeningToMovie.get(screening.getMovie().getId()));

                        screeningItems.add(ScreeningItem.builder()
                                .screeningId(screening.getId())
                                .startTime(screening.getStartTime())
                                .screenName(screening.getScreen().getScreenName())
                                .movieType(screening.getMovieType())
                                .movieSoundType(screening.getMovieSoundType())
                                .build());
                        screeningToMovie.replace(screening.getMovie().getId(), screeningItems);
                    }
                }

            }
            for (Map.Entry<Long, List<ScreeningItem>> entry : screeningToMovie.entrySet()) {
                items.add(new RepertoireItem(idToMovie.get(entry.getKey()), entry.getValue()));
            }

        }
        return new ResponseEntity<>(GetRepertoireResponse.of(request.getCity(), request.getDate(), items), HttpStatus.OK);

    }

    public GetRepertoireResponse addRepertoire(AddRepertoireRequest request) {
        Cinema cinema = cinemasRepository.findByCity(request.getCity());

        repertoireRepository.save(Repertoire.builder()
                .cinema(cinema)
                .date(request.getDate())
                .build());
        return GetRepertoireResponse.of(request.getCity(), request.getDate(), new ArrayList<>());
    }

    public ResponseEntity<?> editRepertoire(EditRepertoireRequest request) {
        Cinema cinema = cinemasRepository.findByCity(request.getCity());
        Optional<Repertoire> repertoire = repertoireRepository.findByCinemaAndDate(cinema, request.getDate());

        if (repertoire.isEmpty()) {
            addRepertoire(AddRepertoireRequest.of(request.getCity(), request.getDate()));
        }

        for (EditScreeningRequest editScreeningRequest : request.getScreenings()) {
            editScreening(editScreeningRequest, request.getCity(), request.getDate());
        }

        return new ResponseEntity<>("Repertoire edited successfully", HttpStatus.OK);
    }
}
