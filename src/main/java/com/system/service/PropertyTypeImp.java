package com.system.service;

import com.system.model.PropertyType;
import com.system.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropertyTypeImp {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;


    public List<PropertyType> fetchAll(){
        List<PropertyType> listOfPropertyTypes = propertyTypeRepository.findAll();

        return listOfPropertyTypes;
    }
}
