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

    @Column(name = "stove")
    private int stove;


    @Column(name = "fridge")
    private int fridge;

    @Column (name = "washingMachine")
    private int washingMachine;

    @Column (name = "dishWasher")
    private int dishWasher;

    @Column(name = "carpets")
    private int carpets;

    @Column (name = "carpetTape")
    private int carpetTape;

    @Column (name = "boltsAndScrews")
    private int boltsAndScrews;

    @Column (name = "curtains")
    private int curtains;

    @Column(name = "curtainrod")
    private int curtainrod;

    @Column (name = "blinds")
    private int blinds;

    @Column (name = "lamps")
    private int lamps;

    @Column (name = "paintings")
    private int paintings;

    @Column (name = "documents")
    private int documents;

    @Column (name = "keys")
    private int keys;

    @Column (name = "cellarAndLoft")
    private int cellarAndLoft;

    @Column (name = "cleaningService")
    private int cleaningService;

    @Column(name = "accessibilityTools")
    private int accessibilityTools;

    @Column (name = "returnKeys")
    private int returnKeys;


   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "assignments_property", joinColumns = @JoinColumn(name = "idassignments"), inverseJoinColumns = @JoinColumn(name = "idproperty_type"))
    private Set<PropertyType> propertyTypes;

    public Assignment(String description, String streetName,
                      int streetNumber, String city, int zip,
                      String floor, String assignmentDate, int stove,
                      int fridge, int washingMachine, int dishWasher,
                      int carpets, int carpetTape, int boltsAndScrews,
                      int curtains, int curtainrod, int blinds,
                      int lamps, int paintings, int documents,
                      int keys, int cellarAndLoft, int cleaningService,
                      int accessibilityTools, int returnKeys, Set<PropertyType> propertyTypes) {
        this.description = description;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zip = zip;
        this.floor = floor;
        this.assignmentDate = Date.valueOf(assignmentDate);
        this.stove = stove;
        this.fridge = fridge;
        this.washingMachine = washingMachine;
        this.dishWasher = dishWasher;
        this.carpets = carpets;
        this.carpetTape = carpetTape;
        this.boltsAndScrews = boltsAndScrews;
        this.curtains = curtains;
        this.curtainrod = curtainrod;
        this.blinds = blinds;
        this.lamps = lamps;
        this.paintings = paintings;
        this.documents = documents;
        this.keys = keys;
        this.cellarAndLoft = cellarAndLoft;
        this.cleaningService = cleaningService;
        this.accessibilityTools = accessibilityTools;
        this.returnKeys = returnKeys;
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

    public int getStove() {
        return stove;
    }

    public void setStove(int stove) {
        this.stove = stove;
    }

    public int getFridge() {
        return fridge;
    }

    public void setFridge(int fridge) {
        this.fridge = fridge;
    }

    public int getWashingMachine() {
        return washingMachine;
    }

    public void setWashingMachine(int washingMachine) {
        this.washingMachine = washingMachine;
    }

    public int getDishWasher() {
        return dishWasher;
    }

    public void setDishWasher(int dishWasher) {
        this.dishWasher = dishWasher;
    }

    public int getCarpets() {
        return carpets;
    }

    public void setCarpets(int carpets) {
        this.carpets = carpets;
    }

    public int getCarpetTape() {
        return carpetTape;
    }

    public void setCarpetTape(int carpetTape) {
        this.carpetTape = carpetTape;
    }

    public int getBoltsAndScrews() {
        return boltsAndScrews;
    }

    public void setBoltsAndScrews(int boltsAndScrews) {
        this.boltsAndScrews = boltsAndScrews;
    }

    public int getCurtains() {
        return curtains;
    }

    public void setCurtains(int curtains) {
        this.curtains = curtains;
    }

    public int getCurtainrod() {
        return curtainrod;
    }

    public void setCurtainrod(int curtainrod) {
        this.curtainrod = curtainrod;
    }

    public int getBlinds() {
        return blinds;
    }

    public void setBlinds(int blinds) {
        this.blinds = blinds;
    }

    public int getLamps() {
        return lamps;
    }

    public void setLamps(int lamps) {
        this.lamps = lamps;
    }

    public int getPaintings() {
        return paintings;
    }

    public void setPaintings(int paintings) {
        this.paintings = paintings;
    }

    public int getDocuments() {
        return documents;
    }

    public void setDocuments(int documents) {
        this.documents = documents;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public int getCellarAndLoft() {
        return cellarAndLoft;
    }

    public void setCellarAndLoft(int cellarAndLoft) {
        this.cellarAndLoft = cellarAndLoft;
    }

    public int getCleaningService() {
        return cleaningService;
    }

    public void setCleaningService(int cleaningService) {
        this.cleaningService = cleaningService;
    }

    public int getAccessibilityTools() {
        return accessibilityTools;
    }

    public void setAccessibilityTools(int accessibilityTools) {
        this.accessibilityTools = accessibilityTools;
    }

    public int getReturnKeys() {
        return returnKeys;
    }

    public void setReturnKeys(int returnKeys) {
        this.returnKeys = returnKeys;
    }
}
