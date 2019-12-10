package com.system.repository;

import com.system.model.Assignment;
import com.system.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {


    public Assignment getAssignmentById(int id);


}
