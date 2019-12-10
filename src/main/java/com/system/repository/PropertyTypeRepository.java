package com.system.repository;

import com.system.model.Assignment;
import com.system.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {

    public PropertyType findByType(String type);

}
