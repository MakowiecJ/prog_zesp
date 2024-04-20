package com.kino.persistence.repositories;

import com.kino.common.City;
import com.kino.persistence.entity.cinema.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Cinema findByCity(final City city);
}
