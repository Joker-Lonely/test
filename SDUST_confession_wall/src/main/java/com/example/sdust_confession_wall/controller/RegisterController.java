package com.example.sdust_confession_wall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @author Joker
 * @data 2022/4/17 17:56
 */
@Controller
public class RegisterController {
    @GetMapping
    public String register(){return "register";}

}
