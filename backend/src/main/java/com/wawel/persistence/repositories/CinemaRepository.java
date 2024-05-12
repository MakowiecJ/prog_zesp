package com.wawel.persistence.repositories;

import com.wawel.common.City;
import com.wawel.entity.cinema.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Cinema findByCity(final City city);
}
