package com.kino.persistence.entity.cinema;

import com.kino.common.ScreenName;
import com.kino.persistence.entity.movies.Screening;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "screen")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Screen {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "screen_name")
    @Enumerated(EnumType.STRING)
    private ScreenName screenName;

    private int capacity;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "screen")
    private List<Screening> screenings;
}
