package com.system.controller;


import com.system.model.Assignment;
import com.system.model.Notice;
import com.system.model.PropertyType;
import com.system.model.User;
import com.system.repository.PropertyTypeRepository;
import com.system.service.AssignmentImp;
import com.system.service.NoticeServiceImp;
import com.system.service.PropertyTypeImp;
import com.system.service.UserServiceImp;
import com.system.tools.TimeMessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    AssignmentImp assignmentImp;

    @Autowired
    NoticeServiceImp noticeServiceImp;

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    @Autowired
    PropertyTypeImp propertyTypeImp;


    //HOME and Create assignment

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
       // TimeMessageGenerator timeMessageGenerator = new TimeMessageGenerator();
        List<Assignment> assignments = assignmentImp.getAssignment();

        List<String> addressLinks = new ArrayList<>();

        for (Assignment a: assignments) {
            String link = "https://www.google.dk/maps/place/"+ a.getStreet_name()+"+" + a.getStreet_number()+",+" + a.getZip()+"+"+ a.getCity() +"/";
            addressLinks.add(link);

        }


    model.addAttribute("addressLinks", addressLinks);
    model.addAttribute("assignments", assignments);
    model.addAttribute("user", user.getName());
    //model.addAttribute("timeMessage", timeMessageGenerator.timeOfTheDay());
    model.addAttribute("timeMessage", new TimeMessageGenerator().timeOfTheDay());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");

        return modelAndView;
    }

    @RequestMapping(value = {"/createAssignment"}, method = RequestMethod.GET)
    public ModelAndView assignmentFormPage(Model model) {
        List<PropertyType> propertyTypes = propertyTypeImp.fetchAll();
        model.addAttribute("propertyTypes", propertyTypes);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assignmentFormPage");
        return modelAndView;
    }

    @RequestMapping (value = "/saveAssignment", method = RequestMethod.POST)
    public ModelAndView postAssignmentFormPage(@ModelAttribute("assignment_Date") String date, @ModelAttribute Assignment assignment, @ModelAttribute("property") String property){
        assignmentImp.createAssignment(assignment, property, date);
        return new ModelAndView("redirect:/home");

    }

    @RequestMapping(value = {"/homeEmployee"}, method = RequestMethod.GET)
    public ModelAndView homeEmployee(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
        TimeMessageGenerator timeMessageGenerator = new TimeMessageGenerator();
        List<Assignment> assignments = assignmentImp.getAssignment();

        List<String> addressLinks = new ArrayList<>();

        for (Assignment a: assignments) {
            String link = "https://www.google.dk/maps/place/"+ a.getStreet_name()+"+" + a.getStreet_number()+",+" + a.getZip()+"+"+ a.getCity() +"/";
            addressLinks.add(link);

        }


        model.addAttribute("addressLinks", addressLinks);
        model.addAttribute("assignments", assignments);
        model.addAttribute("user", user.getName());
        model.addAttribute("timeMessage", timeMessageGenerator.timeOfTheDay());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

//BULLETIN

    @RequestMapping(value = {"/bulletin"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoard() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("bulletin");
        modelAndView.addObject("notices", noticeServiceImp.fetchAll());
        return modelAndView;
    }

    @GetMapping("/deleteNotice/{id}")
    public String deleteNotice(@PathVariable ("id") int id) {
        noticeServiceImp.deleteNotice(id);
        return ("redirect:/bulletin");
    }

    @RequestMapping(value = {"/bulletinEmployee"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoardEmployee() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("bulletinEmployee");
        modelAndView.addObject("notices", noticeServiceImp.fetchAll());
        return modelAndView;
    }


    @RequestMapping(value = {"/noticeFormPage"}, method = RequestMethod.GET)
    public ModelAndView noticeFormpage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("noticeFormPage");
        return modelAndView;
    }



    @RequestMapping (value = "/noticeFormPage", method = RequestMethod.POST)
    public ModelAndView postNoticeFormPage (Authentication authentication, @ModelAttribute("message") String message){

        User user = userServiceImp.currentUser(authentication.getName());
        noticeServiceImp.createNotice(user, String.valueOf(java.time.LocalDate.now()), message);
        return new ModelAndView("redirect:/");

    }


    //EMPLOYEES

    @RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employees");

        return modelAndView;
    }

    @RequestMapping(value = {"/employeesEmployee"}, method = RequestMethod.GET)
    public ModelAndView employeesEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeesEmployee");
        return modelAndView;
    }



}
