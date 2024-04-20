package com.kino.persistence.repositories;

import com.kino.common.ScreenName;
import com.kino.persistence.entity.cinema.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreensRepository extends JpaRepository<Screen, Long> {
    Screen findByCinemaIdAndScreenName(final Long cinemaId, final ScreenName screenName);
}
