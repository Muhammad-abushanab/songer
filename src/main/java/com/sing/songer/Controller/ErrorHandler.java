package com.sing.songer.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ErrorHandler {
    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
