package com.wawel.service.mapper;

import com.wawel.entity.cinema.Screen;
import com.wawel.response.GetScreenResponse;

public class ScreenMapper {
    public static GetScreenResponse toScreenResponse(final Screen screen) {
        return GetScreenResponse.builder()
                .screenId(screen.getId())
                .screenName(screen.getScreenName())
                .build();
    }
}
