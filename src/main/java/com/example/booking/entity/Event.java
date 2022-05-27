package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
@Setter
@Getter
@NoArgsConstructor
public class Event {

    public Event(Date startTime, Date duration,String resourceTitle) {
        this.startTime = startTime;
        this.duration = duration;
        this.resourceTitle = resourceTitle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "duration")
    private Date duration;

    @Column(name = "resourceTitle")
    private String resourceTitle;

    @Column(name = "startTime")
    private Date startTime;

}