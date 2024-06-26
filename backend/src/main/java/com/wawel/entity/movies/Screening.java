package com.wawel.entity.movies;

import com.wawel.common.Availability;
import com.wawel.common.MovieSoundType;
import com.wawel.common.MovieType;
import com.wawel.entity.cinema.Screen;
import com.wawel.entity.cinema.Ticket;
import com.wawel.entity.converter.SeatsConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "screenings")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "repertoire_id")
    private Repertoire repertoire;

    @Convert(converter = SeatsConverter.class)
    private String[][] seats = newSeats();

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "movie_type")
    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @Column(name = "movie_sound_type")
    @Enumerated(EnumType.STRING)
    private MovieSoundType movieSoundType;

    @OneToMany
    private List<Ticket> tickets;

    public static String[][] newSeats() {
        String[][] seats = new String[12][18];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 18; j++) {
                if (j > 12 && j < 16 && i < 11 || j > 15 && i < 8) {
                    seats[i][j] = Availability.NIE_ISTNIEJE.name();
                } else {
                    seats[i][j] = Availability.WOLNE.name();
                }
            }
        }
        return seats;
    }
    public void changeSeatStatus(final int row, final int col) {
        this.seats[row][col] = Availability.ZAJETE.name();
    }
}
