package com.wawel.entity.cinema;

import com.wawel.entity.movies.Screening;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "screens")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Screen {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "screen_name")
    private String screenName;

    private int capacity;

    public Screen(UUID screeningId) {
        this.id = screeningId;
    }
}
