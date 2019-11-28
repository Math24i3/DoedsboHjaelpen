package com.system.controller;


import com.system.model.Assignment;
import com.system.model.Notice;
import com.system.model.User;
import com.system.service.AssignmentImp;
import com.system.service.NoticeServiceImp;
import com.system.service.UserServiceImp;
import com.system.tools.TimeMessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    AssignmentImp assignmentImp;

    @Autowired
    NoticeServiceImp noticeServiceImp;


@RequestMapping( value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home (Model model, Authentication authentication){
    User user = userServiceImp.currentUser(authentication.getName());
    TimeMessageGenerator timeMessageGenerator = new TimeMessageGenerator();

    model.addAttribute("user", user.getName());
    model.addAttribute("timeMessage", timeMessageGenerator.timeOfTheDay());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");


    noticeServiceImp.createNotice(user, "2019-12-12", "Hej");

    return modelAndView;
}

    @RequestMapping( value = {"/bulletin"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoard (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bulletin");

        for (Notice n: noticeServiceImp.fetchAll()
             ) {
            System.out.println(n.getMessage());

        }
        return modelAndView;
    }

    @RequestMapping( value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees (){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Employees");
        return modelAndView;
    }

    @RequestMapping (value = {"/assignmentFormPage"}, method = RequestMethod.GET)
    public ModelAndView assignmentFormPage(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("assignmentFormPage");
    return modelAndView;
    }


}
