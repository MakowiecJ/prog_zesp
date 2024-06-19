package com.wawel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class TicketTypesResponse {
    private int id;
    private String ticketType;
    private float price;
}
