package com.wawel.service.mapper;

import com.wawel.entity.cinema.Ticket;
import com.wawel.entity.movies.Movie;
import com.wawel.response.GeneralMovieResponse;
import com.wawel.response.TicketResponse;
import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;

@UtilityClass
public class MoviesMapper {

    public static GeneralMovieResponse toMovieResponse(final Movie movie) {
        return GeneralMovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .minAge(movie.getMinAge())
                .duration(movie.getDuration())
                .status(movie.getStatus())
                .posterSource(blobToString(movie.getPosterSource()))
                .bigImageSource(blobToString(movie.getBigImageSource()))
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

//    public static String blobToString(Blob blob) throws SQLException, IOException {
//        if (blob == null) return null;
//        byte[] bdata = blob.getBytes(1, (int) blob.length());
//        return new String(bdata);
//    }

    public static String blobToString(final byte[] blob) {
        if (blob == null) return null;
        return new String(blob, StandardCharsets.UTF_8);
    }
}
