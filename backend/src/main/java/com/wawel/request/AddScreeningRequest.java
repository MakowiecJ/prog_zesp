package com.wawel.request;

import com.wawel.common.City;
import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import com.wawel.common.ScreenName;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AddScreeningRequest {
    private City city;
    private ScreenName screenName;
    private Long movieId;
    private LocalDate date;
    private LocalTime startTime;
    private MovieType movieType;
    private MovieSoundType movieSoundType;
}
