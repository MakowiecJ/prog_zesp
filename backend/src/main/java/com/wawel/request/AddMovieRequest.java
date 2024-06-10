package com.wawel.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class AddMovieRequest {

    private String title;

    private String genre;

    private int minAge;

    private int adsDuration;

    private int movieDuration;

    private int cleaningServiceDuration;

    private String posterSource;

    private String bigImageSource;

    private String trailerSource;

    private String description;
}
