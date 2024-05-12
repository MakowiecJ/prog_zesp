package com.wawel.request;

import com.wawel.common.TicketType;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyTicketInfo {
    private TicketType ticketType;
    private int seatRow;
    private int seatNumber;
}
