package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "duration")
@Setter
@Getter
@NoArgsConstructor
public class Duration {

    public Duration(long interval, Event event) {
        this.interval = interval;
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "interval")
    private long interval;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private Event event;
}
