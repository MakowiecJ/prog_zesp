package com.wawel.service.movies;

import com.wawel.common.*;
import com.wawel.entity.movies.Movie;
import com.wawel.persistence.repositories.*;
import com.wawel.request.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
@AllArgsConstructor
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    public Movie addMovie(final AddMovieRequest request) {
        return moviesRepository.save(Movie.builder()
                .title(request.getTitle())
                .genre(request.getGenre())
                .minAge(request.getMinAge())
                .adsDuration(request.getAdsDuration())
                .movieDuration(request.getMovieDuration())
                .cleaningServiceDuration(request.getCleaningServiceDuration())
                .posterSource(request.getPosterSource())
                .bigImageSource(request.getBigImageSource())
                .trailerSource(request.getTrailerSource())
                .status(Status.BRAK_SEANSU)
                .description(request.getDescription())
//                .reviews(new ArrayList<>())
                .screenings(new ArrayList<>())
                .build());
    }

    public List<Movie> getMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movie> getMovie(final UUID movieId) {
        return moviesRepository.findById(movieId);
    }

    public Optional<Movie> editMovie(@PathVariable final UUID movieId, EditMovieRequest request) {
        Optional<Movie> movie = moviesRepository.findById(movieId);
        if (movie.isEmpty()) {
            return Optional.empty();
        }

        Movie movieEntity = movie.get();
        request.getTitle().ifPresent(movieEntity::setTitle);
        request.getGenre().ifPresent(movieEntity::setGenre);
        request.getMinAge().ifPresent(movieEntity::setMinAge);
        request.getAdsDuration().ifPresent(movieEntity::setAdsDuration);
        request.getMovieDuration().ifPresent(movieEntity::setMovieDuration);
        request.getCleaningServiceDuration().ifPresent(movieEntity::setCleaningServiceDuration);
        request.getPosterSource().ifPresent(movieEntity::setPosterSource);
        request.getBigImageSource().ifPresent(movieEntity::setBigImageSource);
        request.getTrailerSource().ifPresent(movieEntity::setTrailerSource);
        request.getDescription().ifPresent(movieEntity::setDescription);

        Movie updatedMovie = moviesRepository.save(movieEntity);
        return Optional.of(updatedMovie);
    }

    public void deleteMovie(final UUID movieId) {
        moviesRepository.deleteById(movieId);
    }

    public ResponseEntity<String> archiveMovie(final UUID movieId) {
        Movie movie = moviesRepository.findById(movieId).orElseThrow();
        movie.setStatus(Status.ZARCHIWIZOWANY);
        moviesRepository.save(movie);

        return new ResponseEntity<>("Movie archived successfully", HttpStatus.OK);
    }
}
