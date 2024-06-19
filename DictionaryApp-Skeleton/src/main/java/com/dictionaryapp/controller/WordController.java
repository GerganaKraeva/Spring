package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController  {

    @GetMapping("/word-add")
    public String viewAddWord() {
        return "word-add";
    }

    @PostMapping("/word-add")
    public String doAddWord(
            @Valid AddWordDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes

    ){

    }
}
