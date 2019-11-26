package com.system.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

@RequestMapping( value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home (){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");
    return modelAndView;
}

    @RequestMapping( value = {"/bulletin"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoard (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bulletin");
        return modelAndView;
    }

    @RequestMapping( value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Employees");
        return modelAndView;
    }
}
