package com.wawel.request;

import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import com.wawel.common.ScreenName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class EditScreeningRequest {
    private Long screeningId;
    private ScreenName screenName;
    private Long movieId;
    private LocalTime startTime;
    private MovieType movieType;
    private MovieSoundType movieSoundType;
}
