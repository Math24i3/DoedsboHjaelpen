package com.system.controller;


import com.system.model.Assignment;
import com.system.model.Notice;
import com.system.model.PropertyType;
import com.system.model.User;
import com.system.repository.PropertyTypeRepository;
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
import java.util.Arrays;
import java.util.HashSet;

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


    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(Model model, Authentication authentication) {
        User user = userServiceImp.currentUser(authentication.getName());
        PropertyType propertyType = propertyTypeRepository.findByType("Hus");
        Assignment assignment = new Assignment("dfd", "df",
                2, "dfd", 2, "sdfs",
                "2015-11-11", 1,
                1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1);

        assignmentImp.createAssignment(assignment, "Lejlighed");

        TimeMessageGenerator timeMessageGenerator = new TimeMessageGenerator();


    model.addAttribute("user", user.getName());
    model.addAttribute("timeMessage", timeMessageGenerator.timeOfTheDay());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");

        return modelAndView;
    }

    @RequestMapping(value = {"/bulletinEmployee"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoardEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bulletinEmployee");
        return modelAndView;
    }

    @RequestMapping(value = {"/employeesEmployee"}, method = RequestMethod.GET)
    public ModelAndView employeesEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeesEmployee");
        return modelAndView;
    }


    @RequestMapping(value = {"/bulletin"}, method = RequestMethod.GET)
    public ModelAndView bulletinBoard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bulletin");
        return modelAndView;
    }

    @RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employees");
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

       @RequestMapping (value = "/saveAssignment", method = RequestMethod.POST)
    public ModelAndView postAssignmentFormPage(@ModelAttribute("Assignment") Assignment assignment, @ModelAttribute("propertyType") PropertyType propertyType, HttpServletRequest httpServletRequest){

           // assignmentImp.createAssignment(assignment.getDescription(),assignment.getStreet_name(),assignment.getStreet_number(),assignment.getCity(),assignment.getZip(),
             //       assignment.getFloor(),assignment.getAssignment_date(),assignment.getStove(),assignment.getFridge(),assignment.getWashing_machine(),assignment.getDish_washer(),assignment.getCarpets(),assignment.getCarpet_tape(),
             //      assignment.getBolts_and_screws(),assignment.getCurtains(),assignment.getCurtainrod(),assignment.getBlinds(),assignment.getLamps(),assignment.getPaintings(),assignment.getDocuments(),assignment.getKeys(),assignment.getCellar_and_loft(),
               //     assignment.getCleaning_service(),assignment.getAccessibility_tools(),assignment.getReturn_keys(),propertyType.getType());

            return new ModelAndView("redirect:/home");
        }

    @RequestMapping (value = "/noticeFormPage", method = RequestMethod.POST)
    public ModelAndView postNoticeFormPage (@ModelAttribute("notice") Notice notice, @ModelAttribute("user") User user1, Authentication authentication, HttpServletRequest httpServletRequest){
    User user = userServiceImp.currentUser(authentication.getName());

    noticeServiceImp.createNotice(user, String.valueOf(notice.getDate()), notice.getMessage());
    return new ModelAndView("redirect:/home");
    }

}
