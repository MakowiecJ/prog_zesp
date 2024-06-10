package com.wawel.persistence.repositories;

import com.wawel.entity.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, UUID> {}
