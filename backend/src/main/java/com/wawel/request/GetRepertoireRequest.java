package com.wawel.request;

import com.wawel.common.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public class GetRepertoireRequest {
    private City city;
    private LocalDate date;
}
