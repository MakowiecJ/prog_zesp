package com.wawel.request;

import com.wawel.common.City;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@Builder
@NoArgsConstructor
public class GetRepertoireRequest {
    private City city;
    private LocalDate date;
}
