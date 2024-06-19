package com.wawel.response;

import com.wawel.common.City;
import com.wawel.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class CinemaResponse {
    private Long id;

    private City city;

    private String address;

    private String phoneNumber;
}
