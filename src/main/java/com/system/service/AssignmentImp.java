package com.system.service;

import com.system.model.Assignment;

import com.system.repository.AssignmentRepository;
import com.system.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AssignmentImp {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    PropertyTypeRepository propertyTypeRepository;



    public void createAssignment(Assignment ass){

        //PropertyType propertyType = propertyTypeRepository.findByType(property);
        //ass.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));

        assignmentRepository.saveAndFlush(ass);
    }



}

