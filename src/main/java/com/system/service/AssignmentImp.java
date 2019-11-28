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

    public void createAssignment(Assignment assignment, String description, String streetName, int streetNumber, String city, int zip, String floor, String date, String type,
                                 boolean stove, boolean fridge, boolean washingMachine, boolean dishWasher, boolean carpets, boolean carpetTape, boolean boltsAndScrews,
                                 boolean curtains, boolean curtainrod, boolean blinds, boolean lamps, boolean paintings, boolean documents, boolean keys,
                                 boolean cellarAndLoft, boolean cleaningService, boolean accessibilityTools, boolean returnKeys){
        PropertyType propertyType = propertyTypeRepository.findByType(type);
        assignment.setDescription(description);
        assignment.setStreetName(streetName);
        assignment.setStreetNumber(streetNumber);
        assignment.setCity(city);
        assignment.setZip(zip);
        assignment.setFloor(floor);
        assignment.setAssignmentDate(date);
        assignment.setStove(stove);
        assignment.setFridge(fridge);
        assignment.setWashingMachine(washingMachine);
        assignment.setDishWasher(dishWasher);
        assignment.setCarpets(carpets);
        assignment.setCarpetTape(carpetTape);
        assignment.setBoltsAndScrews(boltsAndScrews);
        assignment.setCurtains(curtains);
        assignment.setCurtainrod(curtainrod);
        assignment.setBlinds(blinds);
        assignment.setLamps(lamps);
        assignment.setPaintings(paintings);
        assignment.setDocuments(documents);
        assignment.setKeys(keys);
        assignment.setCellarAndLoft(cellarAndLoft);
        assignment.setCleaningService(cleaningService);
        assignment.setAccessibilityTools(accessibilityTools);
        assignment.setReturnKeys(returnKeys);
        assignment.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));
        assignmentRepository.save(assignment);
    }
}

