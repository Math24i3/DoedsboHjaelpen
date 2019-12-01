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

    public void createAssignment(String description, String streetName, int streetNumber, String city,
                                 int zip, String floor, String date, boolean stove, boolean fridge,
                                 boolean washingMashine, boolean dishWasher, boolean carpets,
                                 boolean carpetTape, boolean boltsAndScrews, boolean curtains,
                                 boolean curtainrod, boolean blinds, boolean lamps, boolean paintings,
                                 boolean documents, boolean keys, boolean cellarAndLoft, boolean cleaningService,
                                 boolean accessibilityTools, boolean returnKeys, String type){

        PropertyType propertyType = propertyTypeRepository.findByType(type);
        AssignmentTasks assignmentTasks = new AssignmentTasks(stove, fridge, washingMashine, dishWasher, carpets, carpetTape, boltsAndScrews,
                curtains, curtainrod, blinds, lamps, paintings, documents, keys, cellarAndLoft, cleaningService, accessibilityTools, returnKeys);

        Assignment assignment = new Assignment(description, streetName, streetNumber, city, zip, floor, date, assignmentTasks,
                new HashSet<PropertyType>(Arrays.asList(propertyType)));

        assignmentRepository.save(assignment);
    }

    public void createAssignment(String description, String streetName, int streetNumber, String city,
                                 int zip, String floor, String date, boolean stove, String type){

        PropertyType propertyType = propertyTypeRepository.findByType(type);
        AssignmentTasks assignmentTasks = new AssignmentTasks(stove);

        Assignment assignment = new Assignment(description, streetName, streetNumber, city, zip, floor, date, assignmentTasks,
                new HashSet<PropertyType>(Arrays.asList(propertyType)));

        assignmentRepository.save(assignment);
    }
}

