package com.system.controller;


import com.system.model.Assignment;
import com.system.model.Notice;
import com.system.model.PropertyType;
import com.system.model.User;
import com.system.service.AssignmentImp;
import com.system.service.NoticeServiceImp;
import com.system.service.UserServiceImp;
import com.system.tools.TimeMessageGenerator;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    AssignmentImp assignmentImp;

    @Autowired
    NoticeServiceImp noticeServiceImp;


    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
        TimeMessageGenerator timeMessageGenerator = new TimeMessageGenerator();

        noticeServiceImp.createNotice(user, "1998-08-11", "kæmpe pik");

        model.addAttribute("user", user.getName());
        model.addAttribute("timeMessage", timeMessageGenerator.timeOfTheDay());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        return modelAndView;
    }
//alper

    @RequestMapping(value = {"/bulletin"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bulletin");
        return modelAndView;
    }

    @RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Employees");
        return modelAndView;
    }

    @RequestMapping(value = {"/assignmentFormPage"}, method = RequestMethod.GET)
    public ModelAndView assignmentFormPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assignmentFormPage");
        return modelAndView;
    }


    @RequestMapping(value = {"/noticeFormPage"}, method = RequestMethod.GET)
    public ModelAndView noticeFormpage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("noticeFormPage");
        return modelAndView;
    }

    @RequestMapping(value = "/saveNotice", method = RequestMethod.POST)
    public ModelAndView postNoticeFormPage(@ModelAttribute("notice") Notice notice, @ModelAttribute("user") User user1, Authentication authentication, HttpServletRequest httpServletRequest) {
        User user = userServiceImp.currentUser(authentication.getName());
        noticeServiceImp.createNotice(user, "1998-08-98", "kæmpe pik");
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping (value = "/saveAssignment", method = RequestMethod.POST)
    public ModelAndView postAssignmentFormPage(@ModelAttribute("Assignment") Assignment assignment, @ModelAttribute("propertyType") PropertyType propertyType, HttpServletRequest httpServletRequest){

            assignmentImp.createAssignment(assignment.getDescription(),assignment.getStreetName(),assignment.getStreetNumber(),assignment.getCity(),assignment.getZip(),
                    assignment.getFloor(),assignment.getAssignmentDate(),assignment.getStove(),assignment.getFridge(),assignment.getWashingMachine(),assignment.getDishWasher(),assignment.getCarpets(),assignment.getCarpetTape(),
                    assignment.getBoltsAndScrews(),assignment.getCurtains(),assignment.getCurtainrod(),assignment.getBlinds(),assignment.getLamps(),assignment.getPaintings(),assignment.getDocuments(),assignment.getKeys(),assignment.getCellarAndLoft(),
                    assignment.getCleaningService(),assignment.getAccessibilityTools(),assignment.getReturnKeys(),propertyType.getType());
            return new ModelAndView("redirect:/home");
        }
}


