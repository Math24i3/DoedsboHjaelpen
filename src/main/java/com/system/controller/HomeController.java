package com.system.controller;


import com.system.model.*;
import com.system.repository.AssignmentRepository;
import com.system.repository.DBFileRepository;
import com.system.repository.PropertyTypeRepository;
import com.system.service.*;
import com.system.tools.TimeMessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    DBFileStorageService dbFileStorageService;

    @Autowired
    DBFileRepository dbFileRepository;

    //HOME and Create assignment
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
        List<Assignment> assignments = assignmentImp.getAssignments();
        List<DBFile> files = dbFileRepository.findAll();
        for (GrantedAuthority e: authentication.getAuthorities()) {
            System.out.println(e.getAuthority());
        }
        model.addAttribute("assignments", assignments);
        model.addAttribute("files", files);

        model.addAttribute("user", user.getName());
        model.addAttribute("timeMessage", new TimeMessageGenerator().timeOfTheDay());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
        //
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
   public ModelAndView showAssignment(@PathVariable("id") String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assignment");
        Assignment assignment = assignmentImp.getAssignmentById(id);
       System.out.println(assignment);
       model.addAttribute("assignment", assignment);
        return modelAndView;
   }

   @GetMapping("deleteAssignment/{id}")
   public String deleteAssignment(@PathVariable("id") int id){
        boolean deleted = assignmentImp.deleteAssignmentById(id);

        if(deleted){
            return "redirect:/home";
        }else {
            return "redirect:/home";
        }
   }

//BULLETIN
    @RequestMapping(value = {"/bulletin"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoard() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("bulletin");
        modelAndView.addObject("notices", noticeServiceImp.fetchAll());
        return modelAndView;
    }

//Delete notice
    @GetMapping("/deleteNotice/{id}")
    public String deleteNotice(@PathVariable ("id") int id) {
        noticeServiceImp.deleteNotice(id);
        return ("redirect:/bulletin");
    }

   //notice form
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

    //EMPLOYEES Page
    @RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("employees");
        modelAndView.addObject("users",userServiceImp.fetchAll());

        return modelAndView;
    }


    //Get mapping for home page employee
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

    @GetMapping("/deleteNoticeEmployee/{id}")
    public String deleteNoticeEmployee(@PathVariable("id") int id) {
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

    @RequestMapping(value = {"/employeesEmployee"}, method = RequestMethod.GET)
    public ModelAndView employeesEmployee() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.setViewName("employeesEmployee");
        modelAndView.addObject("users",userServiceImp.fetchAll());
        return modelAndView;
    }

    @RequestMapping(value = "/assignmentEmp/{id}",method = RequestMethod.GET)
    public ModelAndView showAssignmentEmp(@PathVariable("id") String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assignmentEmployee");
        Assignment assignment = assignmentImp.getAssignmentById(id);
        model.addAttribute("assignment", assignment);
        return modelAndView;
    }

    @RequestMapping(value = "/assignmentUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView updateAssignment(@PathVariable("id") String id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateAssignment");

        List<PropertyType> propertyTypes = propertyTypeImp.fetchAll();
        model.addAttribute("propertyTypes", propertyTypes);


        Assignment assignment = assignmentImp.getAssignmentById(id);
        model.addAttribute("assignment", assignment);

        model.addAttribute("pre_property", assignment.getProperty());


        return modelAndView;
    }

    @RequestMapping(value = "/updateAssignment", method = RequestMethod.POST)
    public ModelAndView updateAssignment(@ModelAttribute("assignment_Date") String date, @ModelAttribute Assignment assignment, @ModelAttribute("property") String property) {

        assignmentImp.createAssignment(assignment, property, date);
        return new ModelAndView("redirect:/home");

    }



}
