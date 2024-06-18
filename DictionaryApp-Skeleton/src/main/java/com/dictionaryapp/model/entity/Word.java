package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    private String example;

    @Column(nullable = false)
    private Instant date;

    @ManyToOne(optional = false)
    private Language language;

    @ManyToOne(optional = false)
    private User addedBy;



}
