package com.wawel.persistence.controllers;

import com.wawel.common.City;
import com.wawel.common.TicketType;
import com.wawel.entity.movies.Genre;
import com.wawel.entity.movies.Movie;
import com.wawel.request.*;
import com.wawel.response.*;
import com.wawel.service.movies.MoviesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/movies")
public class CinemaController {

    @Autowired
    private MoviesService service;

    @PostMapping
//    @Secured("ROLE_ADMIN")
    public Movie addMovie(@RequestBody final AddMovieRequest request) {
        return service.addMovie(request);
    }

    @GetMapping
    public List<GeneralMovieResponse> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/cinemas")
    public List<CinemaResponse> getCinemas() {
        return service.getCinemas();
    }

    @GetMapping("/genres")
    public List<Genre> getGenres() {
        return List.of(Genre.values());
    }

    @GetMapping("discount/{discountCode}")
    public Float checkDiscount(@PathVariable final String discountCode) {
        if ("WAWEL_5".equals(discountCode)) {
            return 0.95f;
        } else if ("WAWEL_10".equals(discountCode)) {
            return 0.9f;
        }

        return 0f;
    }

    @GetMapping("/ticketTypes")
    public List<TicketTypesResponse> getTicketTypes() {
        return Arrays.stream(TicketType.values())
                .map(it -> TicketTypesResponse.of(TicketType.getTypeId(it), it.name(), it.getValue()))
                .toList();
    }

    @GetMapping("/screening/{screeningId}/tickets")
    public List<TicketResponse> getScreeningTickets(@PathVariable final String screeningId) {
        return service.getScreeningTickets(screeningId);
    }

    @GetMapping("/{movieId}")
    public GeneralMovieResponse getMovie(@PathVariable final Long movieId) {
        return service.getMovie(movieId);
    }

//    @GetMapping("/userTickets/{userId}")
//    public List<UserTicket> getUserTickets(@PathVariable final String userid) {
//        service.getUserTickets(userId);
//    }

    @DeleteMapping("{movieId}")
//    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> deleteMovie(@PathVariable final Long movieId) {
        return service.deleteMovie(movieId);
    }

    @PostMapping("/edit")
//    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> editMovie(@RequestBody final EditMovieRequest request) {
        return service.editMovie(request);
    }

    @PostMapping("/archive/{movieId}")
//    @Secured("ROLE_ADMIN")
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

    @GetMapping("/screening/{screeningId}")
    public GetScreeningResponse getScreening(@PathVariable final Long screeningId) {
        return service.getScreening(screeningId);
    }

    @PostMapping("/screening")
//    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> addScreening(@RequestBody final AddScreeningRequest request) {
        return service.addScreening(request);
    }

    @DeleteMapping("screening/{screeningId}")
//    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> deleteScreening(@PathVariable final Long screeningId) {
        return service.deleteScreening(screeningId);
    }

    @GetMapping("/repertoire")
    public ResponseEntity<?> getRepertoire(
            @RequestParam final City city,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        return service.getRepertoire(GetRepertoireRequest.of(city, date));
    }

    @PostMapping("/repertoire/edit")
//    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> editRepertoire(final @RequestBody EditRepertoireRequest request) {
        return service.editRepertoire(request);
    }

    @PostMapping("/repertoire")
//    @Secured("ROLE_ADMIN")
    public GetRepertoireResponse addRepertoire(@RequestBody final AddRepertoireRequest request) {
        return service.addRepertoire(request);
    }

    @GetMapping("/reviews/{movieId}")
    public List<MovieReviewResponse> getMovieReviews(@PathVariable final Long movieId) {
        return service.getMovieReviews(movieId);
    }

    @PostMapping("/reviews")
//    @Secured("role_user")
    public ResponseEntity<String> addReview(@RequestBody final AddReviewRequest request) {
        return service.addReview(request);
    }

    @GetMapping("review/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable final Long reviewId) {
        return service.getReview(reviewId);
    }
}
