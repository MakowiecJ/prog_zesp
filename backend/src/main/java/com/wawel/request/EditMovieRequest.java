package com.wawel.request;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EditMovieRequest {

    private Long movieId;

    private String title;

    private String genre;

    private int minAge;

    private int duration;

    private String posterSource;

    private String bigImageSource;

    private String trailerSource;

    private String description;
}
