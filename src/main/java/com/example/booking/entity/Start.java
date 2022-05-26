package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "start")
@Setter
@Getter
@NoArgsConstructor
public class Start {

    public Start(Date date, Event event) {
        this.date = date;
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date date;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private Event event;
}
