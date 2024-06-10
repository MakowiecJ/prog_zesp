package com.wawel.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public class EditMovieRequest {
    private Optional<String> title;

    private Optional<String> genre;

    private Optional<Integer> minAge;

    private Optional<Integer> adsDuration;

    private Optional<Integer> movieDuration;

    private Optional<Integer> cleaningServiceDuration;

    private Optional<String> posterSource;

    private Optional<String> bigImageSource;

    private Optional<String> trailerSource;

    private Optional<String> description;
}
