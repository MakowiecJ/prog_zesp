package com.kino.persistence.entity.cinema;

import com.kino.common.Availability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Seat {
    private int row;
    private int column;
    private Availability availability;
}
