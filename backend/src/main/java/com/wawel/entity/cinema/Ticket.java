package com.wawel.entity.cinema;

import com.wawel.common.TicketType;
import com.wawel.entity.auth.User;
import com.wawel.entity.movies.Screening;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    @Column(name = "seat_row")
    private int seatRow;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;


}
