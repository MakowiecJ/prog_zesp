package com.wawel.entity.cinema;

import com.wawel.common.Availability;
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
