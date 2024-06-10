package com.wawel.request;

import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class AddScreeningRequestTest {
    private UUID screenId;
    private UUID movieId;
    private OffsetDateTime startDate;
    private MovieType movieType;
    private MovieSoundType movieSoundType;
}
