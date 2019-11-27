package com.system.service;

import com.system.model.Assignment;
import com.system.model.PropertyType;
import com.system.repository.AssignmentRepository;
import com.system.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class AssignmentImp {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    public void createAssignment(Assignment assignment, String streetName, int streetNumber, String city, int zip, String floor, String date, String type){
        PropertyType propertyType = propertyTypeRepository.findByType(type);
        assignment.setStreetName(streetName);
        assignment.setStreetNumber(streetNumber);
        assignment.setCity(city);
        assignment.setZip(zip);
        assignment.setFloor(floor);
        assignment.setAssignmentDate(date);
        assignment.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));
        assignmentRepository.save(assignment);
    }
}

