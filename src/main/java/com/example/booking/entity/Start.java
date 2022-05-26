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

    public Start(Collection<Resource> resource, Duration duration, Date date) {
        this.resource = resource;
        this.duration = duration;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Collection<Resource> resource;

    @OneToOne(mappedBy = "start", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Duration duration;

    @Column(name = "start_date")
    private Date date;
}
