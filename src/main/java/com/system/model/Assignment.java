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

    @Column(name = "stove" )
    private Integer stove;

    @Column(name = "fridge")
    private Integer fridge;

    @Column (name = "washing_mashine")
    private Integer washing_machine;

    @Column (name = "dish_washer")
    private Integer dish_washer;

    @Column(name = "carpets")
    private Integer carpets;

    @Column (name = "carpet_tape")
    private Integer carpet_tape;

    @Column (name = "bolts_and_screws")
    private Integer bolts_and_screws;

    @Column (name = "curtains")
    private Integer curtains;

    @Column(name = "curtainrod")
    private Integer curtainrod;

    @Column (name = "blinds")
    private Integer blinds;

    @Column (name = "lamp")
    private Integer lamps;

    @Column (name = "paintings")
    private Integer paintings;

    @Column (name = "documents")
    private Integer documents;

    @Column (name = "keys_customer")
    private Integer keys;

    @Column (name = "cellar_and_loft")
    private Integer cellar_and_loft;

    @Column (name = "cleaning_service")
    private Integer cleaning_service;

    @Column(name = "accessibility_tools")
    private Integer accessibility_tools;

    @Column (name = "return_key")
    private Integer return_keys;


   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "assignments_property", joinColumns = @JoinColumn(name = "idassignments"), inverseJoinColumns = @JoinColumn(name = "idproperty_type"))
    private Set<PropertyType> propertyTypes;

    public Assignment() {
    }

    public Assignment(String description, String street_name,
                      Integer street_number, String city,
                      Integer zip, String floor, String assignment_date,
                      int stove, int fridge, int washing_machine,
                      int dish_washer, int carpets, int carpet_tape,
                      int bolts_and_screws, int curtains, int curtainrod,
                      int blinds, int lamps, int paintings, int documents,
                      int keys, int cellar_and_loft, int cleaning_service,
                      int accessibility_tools, int return_keys) {
        this.description = description;
        this.street_name = street_name;
        this.street_number = street_number;
        this.city = city;
        this.zip = zip;
        this.floor = floor;
        this.assignment_date = Date.valueOf(assignment_date);
        this.stove = stove;
        this.fridge = fridge;
        this.washing_machine = washing_machine;
        this.dish_washer = dish_washer;
        this.carpets = carpets;
        this.carpet_tape = carpet_tape;
        this.bolts_and_screws = bolts_and_screws;
        this.curtains = curtains;
        this.curtainrod = curtainrod;
        this.blinds = blinds;
        this.lamps = lamps;
        this.paintings = paintings;
        this.documents = documents;
        this.cellar_and_loft = cellar_and_loft;
        this.cleaning_service = cleaning_service;
        this.accessibility_tools = accessibility_tools;
        this.return_keys = return_keys;
        this.keys = keys;
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
