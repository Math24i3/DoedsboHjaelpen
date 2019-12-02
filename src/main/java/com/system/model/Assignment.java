package com.system.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassignments")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "street_name")
    private String street_name;

    @Column(name = "street_number")
    private Integer street_number;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private Integer zip;

    @Column(name = "floor")
    private String floor;

    @Column(name = "assignment_date")
    private Date assignment_date;




   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "assignments_property", joinColumns = @JoinColumn(name = "idassignments"), inverseJoinColumns = @JoinColumn(name = "idproperty_type"))
    private Set<PropertyType> propertyTypes;

    public Assignment() {
    }


    public Assignment(String description, String street_name, Integer street_number, String city, Integer zip, String floor, String assignment_date, Set<PropertyType> propertyTypes ) {
        this.description = description;
        this.street_name = street_name;
        this.street_number = street_number;
        this.city = city;
        this.zip = zip;
        this.floor = floor;
        this.assignment_date = Date.valueOf(assignment_date);
        this.propertyTypes = propertyTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public Integer getStreet_number() {
        return street_number;
    }

    public void setStreet_number(Integer street_number) {
        this.street_number = street_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAssignment_date() {
        return String.valueOf(assignment_date);
    }

    public void setAssignment_date(String assignment_date) {
        this.assignment_date = Date.valueOf(assignment_date);
    }


    public Set<PropertyType> getPropertyTypes() {
        return propertyTypes;
    }

    public void setPropertyTypes(Set<PropertyType> propertyTypes) {
        this.propertyTypes = propertyTypes;
    }
}
