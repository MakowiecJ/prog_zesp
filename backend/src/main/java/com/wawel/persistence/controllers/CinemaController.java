package com.wawel.persistence.controllers;

import com.wawel.entity.movies.Movie;
import com.wawel.request.AddMovieRequest;
import com.wawel.request.BuyTicketsRequest;
import com.wawel.response.GetUserInfoResponse;
import com.wawel.service.movies.MoviesService;
import com.wawel.request.EditMovieRequest;
import com.wawel.response.GeneralMovieResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/movies")
public class CinemaController {

    @Autowired
    private MoviesService service;

    @PostMapping
    public Movie addMovie(@RequestBody final AddMovieRequest request) {
        return service.addMovie(request);
    }

    @GetMapping
    public List<GeneralMovieResponse> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/{movieId}")
    public GeneralMovieResponse getMovie(@PathVariable final Long movieId) {
        return service.getMovie(movieId);
    }

    @DeleteMapping("{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable final Long movieId) {
        return service.deleteMovie(movieId);
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editMovie(@RequestBody final EditMovieRequest request) {
        return service.editMovie(request);
    }

    @PostMapping("/archive/{movieId}")
    public ResponseEntity<String> archiveMovie(@PathVariable final Long movieId) {
        return service.archiveMovie(movieId);
    }

    @GetMapping("/users/{userId}")
    public GetUserInfoResponse getUserInfo(@PathVariable final Long userId) {
        return service.getUserInfo(userId);
    }

    @PostMapping("/tickets/buy")
    public ResponseEntity<String> buyTickets(@RequestBody final BuyTicketsRequest request) {
        return service.buyTickets(request);
    }
}
