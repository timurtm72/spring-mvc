package ru.maxima.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(){
        return "first/hello";
    }

    @GetMapping("/goodBay")
    public String goodBayPage(){
        return "first/goodbay";
    }
    @GetMapping("/b")
    public String b(@RequestParam(value = "name",required = false) String name,
                    @RequestParam(value = "surname",required = false) String surname,
                    Model model){
        model.addAttribute("message","Hello " + name + " " + surname);
        return "first/b";
    }
}
