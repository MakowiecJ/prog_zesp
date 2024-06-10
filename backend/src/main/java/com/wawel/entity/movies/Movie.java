package com.wawel.entity.movies;

import com.wawel.common.Status;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "movies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private String genre;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "ads_duration")
    private int adsDuration;

    @Column(name = "movie_duration")
    private int movieDuration;

    @Column(name = "cleaning_service_duration")
    private int cleaningServiceDuration;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "poster_source")
    private String posterSource;

    @Column(name = "big_image_source")
    private String bigImageSource;

    @Column(name = "trailer_source")
    private String trailerSource;

//    @OneToMany(mappedBy = "movie")
//    private List<Review> reviews;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Screening> screenings;

    public Double getAverageRating() {
//        if (reviews.isEmpty()) {
//            return null;
//        }
//        double totalRating = 0;
//        for (Review review : reviews) {
//            totalRating += review.getRating();
//        }
//        return totalRating / reviews.size();

        return 0.0;
    }

    @Transactional
    public Status getStatus() {

        if (status.equals(Status.ZARCHIWIZOWANY)) {
            return status;
        }

        boolean screeningsInThePast = false;
        boolean screeningsInTheFuture = false;
        boolean screeningsToday = false;

        for (Screening screening : screenings) {
//            if (screening.getRepertoire().getDate().isBefore(LocalDate.now())) {
//                screeningsInThePast = true;
//            } else if (screening.getRepertoire().getDate().isAfter(LocalDate.now())) {
//                screeningsInTheFuture = true;
//            } else {
//                screeningsToday = true;
//            }
        }

        if (screeningsInThePast && !screeningsInTheFuture && !screeningsToday) {
            status = Status.NIE_GRANY;
            return status;
        }
        if (!screeningsInThePast && screeningsInTheFuture && !screeningsToday) {
            status = Status.PRZED_PREMIERA;
            return status;
        }
        if (!screeningsInThePast && screeningsToday) {
            status = Status.PREMIERA;
            return status;
        }
        if (screeningsInThePast && screeningsInTheFuture || screeningsToday) {
            status = Status.GRANY;
            return status;
        }

        status = Status.BRAK_SEANSU;
        return status;
    }
}
