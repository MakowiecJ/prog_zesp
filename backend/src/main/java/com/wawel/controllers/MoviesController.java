package com.wawel.controllers;

import com.wawel.entity.movies.Movie;
import com.wawel.request.*;
import com.wawel.service.mapper.MoviesMapper;
import com.wawel.service.movies.MoviesService;
import com.wawel.response.GeneralMovieResponse;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService service;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody final AddMovieRequest request) {
        return new ResponseEntity<>(service.addMovie(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GeneralMovieResponse>> getMovies() {
        List<GeneralMovieResponse> movies = service.getMovies().stream()
                .map(MoviesMapper::toMovieResponse)
                .toList();

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<GeneralMovieResponse> getMovie(@PathVariable final UUID movieId) {
        Optional<Movie> movie = service.getMovie(movieId);
        if (movie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GeneralMovieResponse movies = MoviesMapper.toMovieResponse(movie.get());

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PatchMapping("/{movieId}")
    public ResponseEntity<GeneralMovieResponse> updateMovie(@PathVariable final UUID movieId, @RequestBody final EditMovieRequest request) {
        Optional<Movie> movie = service.editMovie(movieId, request);
        if (movie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(MoviesMapper.toMovieResponse(movie.get()));
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable final UUID movieId) {
        service.deleteMovie(movieId);
        return ResponseEntity.noContent().build();
    }
}
