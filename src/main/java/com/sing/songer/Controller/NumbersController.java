package com.sing.songer.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class NumbersController {
    @Value("${numbers.api.url}")
    private String numbersApiUrl;
    @GetMapping("/num-fact/{number}")
    public String numberFact(Model viewNumber, @PathVariable("number") int number) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(numbersApiUrl+ number,String.class);
        viewNumber.addAttribute("numberFact",response.getBody());
        return "number";
    }
}
