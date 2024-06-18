package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LanguageEnum languageName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    Set<Word> words;
}
