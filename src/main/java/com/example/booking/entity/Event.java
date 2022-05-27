package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "event")
@Setter
@Getter
@NoArgsConstructor
public class Event {

    public Event(Start start, Duration duration, Boolean free, Resource resource, User user) {
        this.start = start;
        this.duration = duration;
        this.resource = resource;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Duration duration;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Resource resource;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Start start;

    @OneToOne(mappedBy = "event")
    private User user;
}