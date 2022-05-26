package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "resource")
@Setter
@Getter
@NoArgsConstructor
public class Resource {

    public Resource(String title, Event event) {
        this.title = title;
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @MapsId
    @JoinColumn(name = "event_id")
    private Event event;
}