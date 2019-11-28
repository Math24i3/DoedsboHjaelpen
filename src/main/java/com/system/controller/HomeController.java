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

    //Create post method for assignment
    @RequestMapping (value = "/save", method = RequestMethod.POST)
    public ModelAndView postAssignmentFormPage(@ModelAttribute("assignment") Assignment assignment, HttpServletRequest httpServletRequest){
        assignmentImp.createAssignment(assignment.getPropertyTypes(),assignment.getDescription(),assignment.getStreetName(),
                assignment.getStreetNumber(),assignment.getCity(),assignment.getZip(),assignment.getFloor(),assignment.getAssignmentDate(),
                assignment.isStove(),assignment.isFridge(), assignment.isWashingMachine(), assignment.isDishWasher(), assignment.isCarpets(),assignment.isCarpetTape(),
                assignment.isBoltsAndScrews(),assignment.isCurtains(), assignment.isCurtainrod(),assignment.isBlinds(), assignment.isLamps(), assignment.isPaintings(),
                assignment.isDocuments(), assignment.isKeys(),assignment.isCellarAndLoft(),
                assignment.isCleaningService(),assignment.isAccessibilityTools(), assignment.isReturnKeys());
        return new ModelAndView("redirect:/home");
    }


}
