package com.wawel.request;

import com.wawel.common.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class EditRepertoireRequest {
    private City city;
    private LocalDate date;
    List<EditScreeningRequest> screenings;
}
