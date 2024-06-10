package com.wawel.response;

import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class GetScreeningResponse {
    private UUID screeningId;
    private OffsetDateTime screeningStart;
    private OffsetDateTime screeningEnd;
    private UUID screenId;
    private UUID movieId;
    private MovieType movieType;
    private MovieSoundType movieSoundType;

    private String title;
    private String description;
    private String genre;
    private Integer adsDuration;
    private Integer movieDuration;
    private Integer cleaningServiceDuration;
    private String bigImageSource;
    private String posterSource;
    private String trailerSource;

//    status
//    averageRating
}
