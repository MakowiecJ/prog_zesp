package com.wawel.request;

import com.wawel.common.City;
import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class AddScreeningRequest {
    private City city;
    private String screenName;
    private Long movieId;
    private LocalDate date;
    private LocalTime startTime;
    private MovieType movieType;
    private MovieSoundType movieSoundType;
}
