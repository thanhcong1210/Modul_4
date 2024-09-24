package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/translate")
    public String dictionary(@RequestParam("word") String word, Model model){
        model.addAttribute("word", word);
        String result = dictionaryService.translate(word);
        model.addAttribute("result", result);
        return "index";
    }
}
