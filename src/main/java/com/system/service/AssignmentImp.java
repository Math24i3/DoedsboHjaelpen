package com.system.service;

import com.system.model.Assignment;

import com.system.model.PropertyType;
import com.system.repository.AssignmentRepository;
import com.system.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Service
public class AssignmentImp {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    public void createAssignment(String date, String city, String floor, int zip, int streetNumber, String streetName,  String type){
        Assignment assignment = new Assignment();
        PropertyType propertyType = propertyTypeRepository.findByType(type);
        assignment.setAssignmentDate(date);
        assignment.setCity(city);
        assignment.setFloor(floor);
        assignment.setZip(zip);
        assignment.setStreetNumber(streetNumber);
        assignment.setStreetName(streetName);

        assignment.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));
        assignmentRepository.save(assignment);
    }
}

