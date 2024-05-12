package com.wawel.response;

import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import com.wawel.common.ScreenName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class ScreeningItem {
    private Long screeningId;
    private ScreenName screenName;
    private LocalTime startTime;
    private MovieType movieType;
    private MovieSoundType movieSoundType;
}
