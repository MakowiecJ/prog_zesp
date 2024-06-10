package com.wawel.service.mapper;

import com.wawel.entity.cinema.Cinema;
import com.wawel.entity.cinema.Ticket;
import com.wawel.entity.movies.Movie;
import com.wawel.response.GeneralMovieResponse;
import com.wawel.response.GetCinemasResponse;
import com.wawel.response.TicketResponse;
import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;

@UtilityClass
public class MoviesMapper {

    public static GetCinemasResponse toCinemaResponse(final Cinema cinema) {
        return GetCinemasResponse.builder()
                .id(cinema.getId())
                .street(cinema.getStreet())
                .postalCode(cinema.getPostalCode())
                .city(cinema.getCity())
                .mailAddress(cinema.getMailAddress())
                .phoneNumber(cinema.getPhoneNumber())
                .build();
    }

    public static GeneralMovieResponse toMovieResponse(final Movie movie) {
        return GeneralMovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .minAge(movie.getMinAge())
                .adsDuration(movie.getAdsDuration())
                .movieDuration(movie.getMovieDuration())
                .cleaningServiceDuration(movie.getCleaningServiceDuration())
                .status(movie.getStatus())
                .posterSource(movie.getPosterSource())
                .bigImageSource(movie.getBigImageSource())
                .trailerSource(movie.getTrailerSource())
                .description(movie.getDescription())
                .averageRating(movie.getAverageRating())
                .build();
    }

    public static TicketResponse toTicketResponse(final Ticket ticket) {
        return TicketResponse.builder()
                .id(ticket.getId())
                .ticketType(ticket.getTicketType())
                .seatRow(ticket.getSeatRow())
                .seatNumber(ticket.getSeatNumber())
                .build();
    }
}
