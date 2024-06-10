package com.wawel.service.movies;

import com.wawel.entity.cinema.Cinema;
import com.wawel.persistence.repositories.CinemasRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CinemasService {
    @Autowired
    private CinemasRepository cinemasRepository;

    public List<Cinema> getCinemas() {
        return cinemasRepository.findAll();
    }

    public Optional<Cinema> getCinema(final UUID cinemaId) {
        return cinemasRepository.findById(cinemaId);
    }
}
