package com.sing.songer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class CaptialaizeController {
    @GetMapping("/capitalize/{word}")
    public String capitalize(Model m , @PathVariable String word){
        m.addAttribute("word" , word.toUpperCase());
        return "capitalize.html";
    }
}
