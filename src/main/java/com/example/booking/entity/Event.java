package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "event")
@Setter
@Getter
@NoArgsConstructor
public class Event {

    public Event(Date startTime, Date endTime,String resourceTitle) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.resourceTitle = resourceTitle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "resourceTitle")
    private String resourceTitle;

    @Column(name = "start_time")
    private Date startTime;

}