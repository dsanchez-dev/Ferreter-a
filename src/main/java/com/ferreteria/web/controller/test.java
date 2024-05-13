package com.ferreteria.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/test")
public class test {

    @GetMapping("")
    public ModelAndView test1(){
        return new ModelAndView("index.html");
    }
}
