package com.wawel.controllers;

import com.wawel.entity.cinema.Cinema;
import com.wawel.entity.movies.Screening;
import com.wawel.request.AddScreeningRequestTest;
import com.wawel.request.EditScreeningRequest;
import com.wawel.response.GetCinemasResponse;
import com.wawel.response.GetScreenResponse;
import com.wawel.response.GetScreeningResponse;
import com.wawel.service.mapper.MoviesMapper;
import com.wawel.service.mapper.ScreeningsMapper;
import com.wawel.service.movies.CinemasService;
import com.wawel.service.movies.ScreeningsService;
import com.wawel.service.movies.ScreensService;
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
@RequestMapping("/cinemas")
public class CinemasController {
    @Autowired
    private CinemasService cinemasService;

    @Autowired
    private ScreeningsService screeningsService;

    @Autowired
    private ScreensService screensService;

    @GetMapping()
    @ApiOperation("Get cinemas")
    public ResponseEntity<List<GetCinemasResponse>> getCinemas() {
        List<GetCinemasResponse> response = cinemasService.getCinemas().stream()
                .map(MoviesMapper::toCinemaResponse)
                .toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{cinemaId}")
    @ApiOperation("Get cinema by ID")
    public ResponseEntity<GetCinemasResponse> getCinema(@PathVariable final UUID cinemaId) {
        Optional<Cinema> cinema = cinemasService.getCinema(cinemaId);
        if (cinema.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GetCinemasResponse response = MoviesMapper.toCinemaResponse(cinema.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{cinemaId}/screenings")
    @ApiOperation("Add new screening")
    public ResponseEntity<GetScreeningResponse> addScreening(
            @PathVariable final UUID cinemaId,
            @RequestBody final AddScreeningRequestTest body
    ) {
        Optional<Screening> addedScreening = screeningsService.addScreening(cinemaId, body);
        if (addedScreening.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GetScreeningResponse response = ScreeningsMapper.toScreeningResponse(addedScreening.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{cinemaId}/screenings")
    @ApiOperation("Get screenings by cinema ID")
    public ResponseEntity<List<GetScreeningResponse>> getScreenings(@PathVariable final UUID cinemaId) {
        List<GetScreeningResponse> cinemaScreenings = screeningsService.getScreenings(cinemaId).stream()
                .map(ScreeningsMapper::toScreeningResponse)
                .toList();

        return new ResponseEntity<>(cinemaScreenings, HttpStatus.OK);
    }

    @GetMapping("/{cinemaId}/screenings/{screeningId}")
    @ApiOperation("Get screening by ID")
    public ResponseEntity<GetScreeningResponse> getScreeningById(@PathVariable final UUID screeningId) {
        Optional<Screening> screening = screeningsService.getScreeningById(screeningId);
        if (screening.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GetScreeningResponse response = ScreeningsMapper.toScreeningResponse(screening.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{cinemaId}/screenings/{screeningId}")
    @ApiOperation("Update screening by ID")
    public ResponseEntity<GetScreeningResponse> updateScreening(
            @PathVariable final UUID cinemaId,
            @PathVariable final UUID screeningId,
            @RequestBody final EditScreeningRequest body
    ) {
        Optional<Cinema> cinema = cinemasService.getCinema(cinemaId);
        if (cinema.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Screening> screening = screeningsService.updateScreening(cinemaId, screeningId, body);
        if (screening.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GetScreeningResponse response = ScreeningsMapper.toScreeningResponse(screening.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{cinemaId}/screenings/{screeningId}")
    @ApiOperation("Delete screening by ID")
    public ResponseEntity<Void> deleteScreening(
            @PathVariable final UUID cinemaId,
            @PathVariable final UUID screeningId
    ) {
        screeningsService.deleteScreening(cinemaId, screeningId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{cinemaId}/screens")
    @ApiOperation("Get cinema screens")
    public List<GetScreenResponse> getScreens(@PathVariable final UUID cinemaId) {
        return screensService.getScreens(cinemaId);
    }
}
