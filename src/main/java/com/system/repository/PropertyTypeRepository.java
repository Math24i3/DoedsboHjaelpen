package com.system.repository;

import com.system.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {

    public PropertyType findByType(String type);
}
