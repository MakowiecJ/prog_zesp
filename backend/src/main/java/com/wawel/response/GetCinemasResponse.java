package com.wawel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class GetCinemasResponse {
    private UUID id;
    private String street;
    private String postalCode;
    private String city;
    private String mailAddress;
    private String phoneNumber;
}
