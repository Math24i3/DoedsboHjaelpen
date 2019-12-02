package com.system.service;

import com.system.model.Assignment;

import com.system.model.AssignmentTasks;
import com.system.model.PropertyType;
import com.system.repository.AssignmentRepository;
import com.system.repository.AssignmentTasksRepository;
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

    @Autowired
    AssignmentTasksRepository assignmentTasksRepository;
/*
    public void createAssignment(String description, String streetName, int streetNumber, String city,
                                 int zip, String floor, String date, int stove, int fridge,
                                 int washingMashine, int dishWasher, int carpets,
                                 int carpetTape, int boltsAndScrews, int curtains,
                                 int curtainrod, int blinds, int lamps, int paintings,
                                 int documents, int keys, int cellarAndLoft, int cleaningService,
                                 int accessibilityTools, int returnKeys, String type){

        PropertyType propertyType = propertyTypeRepository.findByType(type);
        AssignmentTasks assignmentTasks = new AssignmentTasks(stove, fridge, washingMashine, dishWasher, carpets, carpetTape, boltsAndScrews,
                curtains, curtainrod, blinds, lamps, paintings, documents, keys, cellarAndLoft, cleaningService, accessibilityTools, returnKeys);

        Assignment assignment = new Assignment(description, streetName, streetNumber, city, zip, floor, date, assignmentTasks,
                new HashSet<PropertyType>(Arrays.asList(propertyType)));

        assignmentRepository.save(assignment);
    }
*/
    public void createAssignment(String description, String streetName, int streetNumber, String city,
                                 int zip, String floor, String date, int stove, String type){

        PropertyType propertyType = propertyTypeRepository.findByType(type);
        AssignmentTasks assignmentTasks = new AssignmentTasks(stove);

        Assignment assignment = new Assignment(description, streetName, streetNumber, city, zip, floor, date, assignmentTasks,
                new HashSet<PropertyType>(Arrays.asList(propertyType)));

        assignmentRepository.save(assignment);
    }
}

