package com.wawel.request;

import com.wawel.common.City;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EditRepertoireRequest {
    private City city;
    private LocalDate date;
    List<EditScreeningRequest> screenings;
}
