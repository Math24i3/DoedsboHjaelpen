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

    public void createAssignment(String description, String streetName, int streetNumber, String city,
                                 int zip, String floor, String date, boolean stove, boolean fridge,
                                 boolean washingMashine, boolean dishWasher, boolean carpets,
                                 boolean carpetTape, boolean boltsAndScrews, boolean curtains,
                                 boolean curtainrod, boolean blinds, boolean lamps, boolean paintings,
                                 boolean documents, boolean keys, boolean cellarAndLoft, boolean cleaningService,
                                 boolean accessibilityTools, boolean returnKeys, String type){

        Assignment assignment = new Assignment();
        assignment.setDescription(description);
        assignment.setStreetNumber(streetNumber);
        assignment.setStreetName(streetName);
        assignment.setCity(city);
        assignment.setZip(zip);
        assignment.setFloor(floor);
        assignment.setAssignmentDate(date);
        assignment.setStove(stove);
        assignment.setFridge(fridge);
        assignment.setWashingMachine(washingMashine);
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

        PropertyType propertyType = propertyTypeRepository.findByType(type);
        assignment.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));
        assignmentRepository.save(assignment);
    }
}

