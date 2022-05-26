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

    public Resource(String title, Collection<Start> starts) {
        this.title = title;
        this.starts = starts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    private Collection<Start> starts;

}