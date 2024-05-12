package com.wawel.request;

import com.wawel.common.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@Builder
public class AddRepertoireRequest {
    private City city;
    private LocalDate date;
}
