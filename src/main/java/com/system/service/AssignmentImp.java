package com.system.service;

import com.system.model.Assignment;

import com.system.model.PropertyType;
import com.system.repository.AssignmentRepository;
import com.system.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class AssignmentImp {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    PropertyTypeRepository propertyTypeRepository;



    public void createAssignment(Assignment ass, String property, String date){

        PropertyType propertyType = propertyTypeRepository.findByType(property);
        ass.setAssignment_date(date);
        ass.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));
        assignmentRepository.saveAndFlush(ass);
    }

    public List<Assignment> getAssignment(){
        List<Assignment> assignments = assignmentRepository.findAll();

        for (Assignment a: assignments) {
            a.setAddressLink("https://www.google.dk/maps/place/"+ a.getStreet_name()+"+" + a.getStreet_number()+",+" + a.getZip()+"+"+ a.getCity() +"/");

        }
        return assignments;

    }



}

