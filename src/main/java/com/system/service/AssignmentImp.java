package com.system.service;

import com.system.model.Assignment;

import com.system.model.PropertyType;
import com.system.model.Role;
import com.system.repository.AssignmentRepository;
import com.system.repository.PropertyTypeRepository;
import com.system.tools.Toolbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    JdbcTemplate template;



    public void createAssignment(Assignment ass, String property, String date){

        PropertyType propertyType = propertyTypeRepository.findByType(property);
        ass.setAssignment_date(date);
        ass.setPropertyTypes(new HashSet<PropertyType>(Arrays.asList(propertyType)));
        assignmentRepository.saveAndFlush(ass);
    }

    public List<Assignment> getAssignments(){
        List<Assignment> assignments = assignmentRepository.findAll();
        Toolbox toolbox = new Toolbox();

        for (Assignment a: assignments) {
            a.setAddressLink("https://www.google.com/maps/dir/?api=1&destination=" + toolbox.replaceWhiteSpace(a.getStreet_name(), '+') + "+" + a.getStreet_number() + ",+" + a.getZip() + "+" + a.getCity() + "/");

        }
        return assignments;

    }

    public Assignment getAssignmentById(String id){
        int finalID = Integer.valueOf(id);
        Assignment assignment = assignmentRepository.getAssignmentById(finalID);
        return assignment;
    }

    public boolean deleteAssignmentById(int id){
        String sql = "DELETE FROM assignments WHERE assignments.idassignments = ?;";

        return template.update(sql, id) + template.update(sql, id) > 0;

    }


}

