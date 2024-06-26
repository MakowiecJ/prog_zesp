package com.wawel.persistence.repositories;

import com.wawel.entity.movies.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
    Review findByMovieIdAndUserId(Long movieId, Long userId);
}
