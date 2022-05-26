package com.example.booking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "start")
@Setter
@Getter
@NoArgsConstructor
public class Start {

    public Start(Resource resource, Duration duration, Date date) {
        this.resource = resource;
        this.duration = duration;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @OneToOne(mappedBy = "start", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Duration duration;

    @Column(name = "start_date")
    private Date date;
}
