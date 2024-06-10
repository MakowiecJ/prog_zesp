package com.wawel.entity.cinema;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cinemas")
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "street")
    private String street;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

//    @OneToMany
//    private List<Repertoire> repertoires;

    @OneToMany
    private List<Screen> screens;
}
