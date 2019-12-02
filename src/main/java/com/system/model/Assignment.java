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
    private int id;

    @Column(name = "description" )
    private String description;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private int zip;

    @Column(name = "floor")
    private String floor;

    @Column(name = "assignment_date")
    private Date assignmentDate;


    @OneToOne(mappedBy = "assignment", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private AssignmentTasks assignmentTasks;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "assignments_property", joinColumns = @JoinColumn(name = "idassignments"), inverseJoinColumns = @JoinColumn(name = "idproperty_type"))
    private Set<PropertyType> propertyTypes;

    public Assignment(String description, String streetName, int streetNumber, String city, int zip, String floor, String assignmentDate, AssignmentTasks assignmentTasks, Set<PropertyType> propertyTypes) {
        this.description = description;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zip = zip;
        this.floor = floor;
        this.assignmentDate = Date.valueOf(assignmentDate);
        this.assignmentTasks = assignmentTasks;
        this.propertyTypes = propertyTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAssignmentDate() {
        return assignmentDate.toString();
    }

    public void setAssignmentDate(String str) {
        this.assignmentDate = Date.valueOf(str);
    }

    public Set<PropertyType> getPropertyTypes() {
        return propertyTypes;
    }

    public void setPropertyTypes(Set<PropertyType> propertyTypes) {
        this.propertyTypes = propertyTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }


}
