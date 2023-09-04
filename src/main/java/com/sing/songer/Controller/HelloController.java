package com.sing.songer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String getName(Model m , @RequestParam(value = "name",required = false ,defaultValue = "Guest") String name){
        m.addAttribute("name" , name);
        return "hello";
    }
    @GetMapping("/")
    public String root(){
        return "index";
    }
}
