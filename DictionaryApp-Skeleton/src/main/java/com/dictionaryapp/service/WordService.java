package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDto;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WordService {

    private LanguageRepository languageRepository;
    private UserSession userSession;

    public WordService(LanguageRepository languageRepository, UserSession userSession, UserRepository userRepository) {
        this.languageRepository = languageRepository;
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    public void add(AddWordDto data) {
        Word word = new Word();


    }
}
