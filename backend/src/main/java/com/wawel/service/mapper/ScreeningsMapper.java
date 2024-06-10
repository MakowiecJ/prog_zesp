package com.wawel.service.mapper;

import com.wawel.entity.movies.Screening;
import com.wawel.response.GetScreeningResponse;

public class ScreeningsMapper {
    public static GetScreeningResponse toScreeningResponse(final Screening screening) {
        return GetScreeningResponse.builder()
            .screeningId(screening.getId())
            .screenId(screening.getScreen().getId())
            .screeningStart(screening.getStartDate())
            .screeningEnd(screening.getStartDate()
                    .plusMinutes(screening.getMovie().getAdsDuration())
                    .plusMinutes(screening.getMovie().getMovieDuration())
                    .plusMinutes(screening.getMovie().getCleaningServiceDuration()))
            .movieId(screening.getMovie().getId())
            .movieType(screening.getMovieType())
            .movieSoundType(screening.getMovieSoundType())
            .title(screening.getMovie().getTitle())
            .description(screening.getMovie().getDescription())
            .genre(screening.getMovie().getGenre())
            .adsDuration(screening.getMovie().getAdsDuration())
            .movieDuration(screening.getMovie().getMovieDuration())
            .cleaningServiceDuration(screening.getMovie().getCleaningServiceDuration())
            .bigImageSource(screening.getMovie().getBigImageSource())
            .posterSource(screening.getMovie().getPosterSource())
            .trailerSource(screening.getMovie().getTrailerSource())
            .build();
    }
}
