package com.system.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "assignments")
public class tester {

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

    @Column (name = "lamps")
    private Integer lamps;

    @Column (name = "paintings")
    private Integer paintings;

    @Column (name = "documents")
    private Integer documents;

    @Column (name = "keys")
    private Integer keys;

    @Column (name = "cellar_and_loft")
    private Integer cellar_and_loft;

    @Column (name = "cleaning_service")
    private Integer cleaning_service;

    @Column(name = "accessibility_tools")
    private Integer accessibility_tools;

    @Column (name = "return_keys")
    private Integer return_keys;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "assignments_property", joinColumns = @JoinColumn(name = "idassignments"), inverseJoinColumns = @JoinColumn(name = "idproperty_type"))
    private Set<PropertyType> propertyTypes;

    public tester() {
    }

    public tester(String description, String street_name, Integer street_number,
                      String city, Integer zip, String floor, String assignment_date,
                      Integer stove, Integer fridge, Integer washing_machine,
                      Integer dish_washer, Integer carpets, Integer carpet_tape,
                      Integer bolts_and_screws, Integer curtains, Integer curtainrod,
                      Integer blinds, Integer lamps, Integer paintings, Integer documents,
                      Integer keys, Integer cellar_and_loft, Integer cleaning_service,
                      Integer accessibility_tools, Integer return_keys, Set<PropertyType> propertyTypes) {
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
        this.keys = keys;
        this.cellar_and_loft = cellar_and_loft;
        this.cleaning_service = cleaning_service;
        this.accessibility_tools = accessibility_tools;
        this.return_keys = return_keys;
        this.propertyTypes = propertyTypes;
    }

    public tester(String description, String street_name, Integer street_number, String city, Integer zip, String floor, String assignment_date) {
        this.description = description;
        this.street_name = street_name;
        this.street_number = street_number;
        this.city = city;
        this.zip = zip;
        this.floor = floor;
        this.assignment_date = Date.valueOf(assignment_date);
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

    public Integer getStove() {
        return stove;
    }

    public void setStove(Integer stove) {
        this.stove = stove;
    }

    public Integer getFridge() {
        return fridge;
    }

    public void setFridge(Integer fridge) {
        this.fridge = fridge;
    }

    public Integer getWashing_machine() {
        return washing_machine;
    }

    public void setWashing_machine(Integer washing_machine) {
        this.washing_machine = washing_machine;
    }

    public Integer getDish_washer() {
        return dish_washer;
    }

    public void setDish_washer(Integer dish_washer) {
        this.dish_washer = dish_washer;
    }

    public Integer getCarpets() {
        return carpets;
    }

    public void setCarpets(Integer carpets) {
        this.carpets = carpets;
    }

    public Integer getCarpet_tape() {
        return carpet_tape;
    }

    public void setCarpet_tape(Integer carpet_tape) {
        this.carpet_tape = carpet_tape;
    }

    public Integer getBolts_and_screws() {
        return bolts_and_screws;
    }

    public void setBolts_and_screws(Integer bolts_and_screws) {
        this.bolts_and_screws = bolts_and_screws;
    }

    public Integer getCurtains() {
        return curtains;
    }

    public void setCurtains(Integer curtains) {
        this.curtains = curtains;
    }

    public Integer getCurtainrod() {
        return curtainrod;
    }

    public void setCurtainrod(Integer curtainrod) {
        this.curtainrod = curtainrod;
    }

    public Integer getBlinds() {
        return blinds;
    }

    public void setBlinds(Integer blinds) {
        this.blinds = blinds;
    }

    public Integer getLamps() {
        return lamps;
    }

    public void setLamps(Integer lamps) {
        this.lamps = lamps;
    }

    public Integer getPaintings() {
        return paintings;
    }

    public void setPaintings(Integer paintings) {
        this.paintings = paintings;
    }

    public Integer getDocuments() {
        return documents;
    }

    public void setDocuments(Integer documents) {
        this.documents = documents;
    }

    public Integer getKeys() {
        return keys;
    }

    public void setKeys(Integer keys) {
        this.keys = keys;
    }

    public Integer getCellar_and_loft() {
        return cellar_and_loft;
    }

    public void setCellar_and_loft(Integer cellar_and_loft) {
        this.cellar_and_loft = cellar_and_loft;
    }

    public Integer getCleaning_service() {
        return cleaning_service;
    }

    public void setCleaning_service(Integer cleaning_service) {
        this.cleaning_service = cleaning_service;
    }

    public Integer getAccessibility_tools() {
        return accessibility_tools;
    }

    public void setAccessibility_tools(Integer accessibility_tools) {
        this.accessibility_tools = accessibility_tools;
    }

    public Integer getReturn_keys() {
        return return_keys;
    }

    public void setReturn_keys(Integer return_keys) {
        this.return_keys = return_keys;
    }

    public Set<PropertyType> getPropertyTypes() {
        return propertyTypes;
    }

    public void setPropertyTypes(Set<PropertyType> propertyTypes) {
        this.propertyTypes = propertyTypes;
    }
}
