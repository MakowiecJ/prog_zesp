package com.wawel.response;

import com.wawel.common.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    private Long id;
    private TicketType ticketType;
    private int seatRow;
    private int seatNumber;
}
