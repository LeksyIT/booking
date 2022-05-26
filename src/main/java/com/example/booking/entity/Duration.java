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

    public Duration(Start start,long interval) {
        this.start = start;
        this.interval = interval;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "start_id")
    private Start start;

    @Column(name = "interval")
    private long interval;
}
