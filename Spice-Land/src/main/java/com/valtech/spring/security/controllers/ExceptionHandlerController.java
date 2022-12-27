package com.valtech.spring.security.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

 

@ControllerAdvice
public class ExceptionHandlerController {

 

    @ExceptionHandler(Exception.class)
    public String exceptionHandling(Model model){


        return "/errorpage";
    }

}
