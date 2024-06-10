package com.wawel.service.movies;

import com.wawel.entity.cinema.Cinema;
import com.wawel.entity.cinema.Screen;
import com.wawel.entity.movies.Movie;
import com.wawel.entity.movies.Screening;
import com.wawel.persistence.repositories.CinemasRepository;
import com.wawel.persistence.repositories.MoviesRepository;
import com.wawel.persistence.repositories.ScreeningsRepository;
import com.wawel.persistence.repositories.ScreensRepository;
import com.wawel.request.AddScreeningRequestTest;
import com.wawel.request.EditScreeningRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ScreeningsService {
    @Autowired
    private ScreeningsRepository screeningsRepository;

    @Autowired
    private CinemasRepository cinemasRepository;

    @Autowired
    private ScreensRepository screensRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    public Optional<Screening> addScreening(final UUID cinemaId, AddScreeningRequestTest request) {
        Optional<Cinema> cinema = cinemasRepository.findById(cinemaId);
        if (cinema.isEmpty()) { return Optional.empty(); }

        Optional<Screen> screen = screensRepository.findById(request.getScreenId());
        if (screen.isEmpty()) { return Optional.empty(); }

        Optional<Movie> movie = moviesRepository.findById(request.getMovieId());
        if (movie.isEmpty()) { return Optional.empty(); }

        Screening screening = Screening.builder()
                .screen(screen.get())
                .movie(movie.get())
                .startDate(request.getStartDate())
                .movieType(request.getMovieType())
                .movieSoundType(request.getMovieSoundType())
                .build();
        Screening savedScreening = screeningsRepository.save(screening);

        return Optional.of(savedScreening);
    }

    public List<Screening> getScreenings(final UUID cinemaId) {
        return screeningsRepository.findByCinemaId(cinemaId);
    }

    public Optional<Screening> getScreeningById(final UUID screeningId) {
        return screeningsRepository.findById(screeningId);
    }

    public Optional<Screening> updateScreening(final UUID cinemaId, final UUID screeningId, final EditScreeningRequest request) {
        Optional<Cinema> cinema = cinemasRepository.findById(cinemaId);
        if (cinema.isEmpty()) {
            return Optional.empty();
        }

        Optional<Screening> screening = screeningsRepository.findById(screeningId);
        if (screening.isEmpty()) {
            return Optional.empty();
        }

        Screening updatedScreening = screening.get();
        if (request.getStartDate() != null) {
            updatedScreening.setStartDate(request.getStartDate());
        }
        if (request.getScreenId() != null) {
            screensRepository.findById(request.getScreenId()).ifPresent(updatedScreening::setScreen);
        }

        screeningsRepository.save(updatedScreening);

        return Optional.of(updatedScreening);
    }

    public void deleteScreening(final UUID cinemaId, final UUID screeningId) {
        Optional<Cinema> cinema = cinemasRepository.findById(cinemaId);
        if (cinema.isEmpty()) { return; }

        try {
            screeningsRepository.deleteById(screeningId);
        } catch (Exception e) {}
    }
}
