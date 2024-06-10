package com.wawel.persistence.repositories;

import com.wawel.entity.movies.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScreeningsRepository extends JpaRepository<Screening, UUID> {
    @Query(value = "SELECT * FROM SCREENINGS INNER JOIN SCREENS ON SCREENINGS.SCREEN_ID = SCREENS.ID WHERE CINEMA_ID = ?", nativeQuery = true)
    List<Screening> findByCinemaId(final UUID cinemaId);
}
