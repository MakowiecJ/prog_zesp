package com.wawel.response;

import com.wawel.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class GeneralMovieResponse {
    private UUID id;
    private String title;
    private String genre;
    private int minAge;
    private int adsDuration;
    private int movieDuration;
    private int cleaningServiceDuration;
    private Double averageRating;
    private Status status;
    private String posterSource;
    private String bigImageSource;
    private String trailerSource;
    private String description;
}
