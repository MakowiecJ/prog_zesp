package com.wawel.service.movies;

import com.wawel.persistence.repositories.ScreensRepository;
import com.wawel.response.GetScreenResponse;
import com.wawel.service.mapper.ScreenMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ScreensService {
    @Autowired
    private ScreensRepository screensRepository;

    public List<GetScreenResponse> getScreens(final UUID cinemaId) {
        return screensRepository.findByCinemaId(cinemaId).stream()
                .map(ScreenMapper::toScreenResponse)
                .toList();
    }
}
