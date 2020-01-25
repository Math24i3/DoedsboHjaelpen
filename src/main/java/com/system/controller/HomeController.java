package com.system.controller;


import com.system.model.*;
import com.system.repository.PropertyTypeRepository;
import com.system.service.AssignmentImp;
import com.system.service.NoticeServiceImp;
import com.system.service.PropertyTypeImp;
import com.system.service.UserServiceImp;
import com.system.tools.TimeMessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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

    private static final Logger logger =
            LoggerFactory.getLogger(HomeController.class);


    //HOME and Create assignment
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
        List<Assignment> assignments = assignmentImp.getAssignments();
        for (GrantedAuthority e: authentication.getAuthorities()) {
            System.out.println(e.getAuthority());
        }
    model.addAttribute("assignments", assignments);
    model.addAttribute("user", user.getName());
    model.addAttribute("timeMessage", new TimeMessageGenerator().timeOfTheDay());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");

        return modelAndView;
        //
    }

    @RequestMapping(value = {"/homeEmployee"}, method = RequestMethod.GET)
    public ModelAndView homeEmployee(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
        TimeMessageGenerator timeMessageGenerator = new TimeMessageGenerator();
        List<Assignment> assignments = assignmentImp.getAssignments();

        model.addAttribute("assignments", assignments);
        model.addAttribute("user", user.getName());
        model.addAttribute("timeMessage", timeMessageGenerator.timeOfTheDay());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homeEmployee");
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

   @RequestMapping(value = "/assignment/{id}", method = RequestMethod.GET)
   public ModelAndView showAssignment(@PathVariable("id") Integer id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assignment");
        Assignment assignment = assignmentImp.getAssignmentById(id);
       System.out.println(assignment);
       model.addAttribute("assignment", assignment);
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

    @GetMapping("/deleteNoticeEmployee/{id}")
    public String deleteNoticeEmployee(@PathVariable ("id") int id) {
        noticeServiceImp.deleteNotice(id);
        return ("redirect:/bulletinEmployee");
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
    public ModelAndView postNoticeFormPage (Authentication authentication, Role role, @ModelAttribute("message") String message) {

        User user = userServiceImp.currentUser(authentication.getName());
        noticeServiceImp.createNotice(user, String.valueOf(java.time.LocalDate.now()), message);

        boolean checkAuth = false;
        for (GrantedAuthority x : authentication.getAuthorities()) {
            if (x.getAuthority().equals("ADMIN_USER")) {
                checkAuth = true;
                break;
            }

        }

        if (checkAuth) {
            return new ModelAndView("redirect:/bulletin");
        } else  {
            return new ModelAndView("redirect:/bulletinEmployee");
        }



    }
    //EMPLOYEES
    @RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("employees");
        modelAndView.addObject("users",userServiceImp.fetchAll());

        return modelAndView;
    }

    @RequestMapping(value = {"/employeesEmployee"}, method = RequestMethod.GET)
    public ModelAndView employeesEmployee() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("employeesEmployee");
        modelAndView.addObject("users",userServiceImp.fetchAll());
        return modelAndView;
    }


}
