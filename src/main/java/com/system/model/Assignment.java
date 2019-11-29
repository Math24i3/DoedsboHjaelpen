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
    private boolean stove;

    @Column(name = "fridge")
    private boolean fridge;

    @Column (name = "washingMachine")
    private boolean washingMachine;

    @Column (name = "dishWasher")
    private boolean dishWasher;

    @Column(name = "carpets")
    private boolean carpets;

    @Column (name = "carpetTape")
    private boolean carpetTape;

    @Column (name = "boltsAndScrews")
    private boolean boltsAndScrews;

    @Column (name = "curtains")
    private boolean curtains;

    @Column(name = "curtainrod")
    private boolean curtainrod;

    @Column (name = "blinds")
    private boolean blinds;

    @Column (name = "lamps")
    private boolean lamps;

    @Column (name = "paintings")
    private boolean paintings;

    @Column (name = "documents")
    private boolean documents;

    @Column (name = "keys")
    private boolean keys;

    @Column (name = "cellarAndLoft")
    private boolean cellarAndLoft;

    @Column (name = "cleaningService")
    private boolean cleaningService;

    @Column(name = "accessibilityTools")
    private boolean accessibilityTools;

    @Column (name = "returnKeys")
    private boolean returnKeys;




    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "assignments_property", joinColumns = @JoinColumn(name = "idassignments"), inverseJoinColumns = @JoinColumn(name = "idproperty_type"))
    private Set<PropertyType> propertyTypes;



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

    public boolean isStove() {
        return stove;
    }

    public void setStove(boolean stove) {
        this.stove = stove;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isWashingMachine() {
        return washingMachine;
    }

    public void setWashingMachine(boolean washingMachine) {
        this.washingMachine = washingMachine;
    }

    public boolean isDishWasher() {
        return dishWasher;
    }

    public void setDishWasher(boolean dishWasher) {
        this.dishWasher = dishWasher;
    }

    public boolean isCarpets() {
        return carpets;
    }

    public void setCarpets(boolean carpets) {
        this.carpets = carpets;
    }

    public boolean isCarpetTape() {
        return carpetTape;
    }

    public void setCarpetTape(boolean carpetTape) {
        this.carpetTape = carpetTape;
    }

    public boolean isBoltsAndScrews() {
        return boltsAndScrews;
    }

    public void setBoltsAndScrews(boolean boltsAndScrews) {
        this.boltsAndScrews = boltsAndScrews;
    }

    public boolean isCurtains() {
        return curtains;
    }

    public void setCurtains(boolean curtains) {
        this.curtains = curtains;
    }

    public boolean isCurtainrod() {
        return curtainrod;
    }

    public void setCurtainrod(boolean curtainrod) {
        this.curtainrod = curtainrod;
    }

    public boolean isBlinds() {
        return blinds;
    }

    public void setBlinds(boolean blinds) {
        this.blinds = blinds;
    }

    public boolean isLamps() {
        return lamps;
    }

    public void setLamps(boolean lamps) {
        this.lamps = lamps;
    }

    public boolean isPaintings() {
        return paintings;
    }

    public void setPaintings(boolean paintings) {
        this.paintings = paintings;
    }

    public boolean isDocuments() {
        return documents;
    }

    public void setDocuments(boolean documents) {
        this.documents = documents;
    }

    public boolean isKeys() {
        return keys;
    }

    public void setKeys(boolean keys) {
        this.keys = keys;
    }

    public boolean isCellarAndLoft() {
        return cellarAndLoft;
    }

    public void setCellarAndLoft(boolean cellarAndLoft) {
        this.cellarAndLoft = cellarAndLoft;
    }

    public boolean isCleaningService() {
        return cleaningService;
    }

    public void setCleaningService(boolean cleaningService) {
        this.cleaningService = cleaningService;
    }

    public boolean isAccessibilityTools() {
        return accessibilityTools;
    }

    public void setAccessibilityTools(boolean accessibilityTools) {
        this.accessibilityTools = accessibilityTools;
    }

    public boolean isReturnKeys() {
        return returnKeys;
    }

    public void setReturnKeys(boolean returnKeys) {
        this.returnKeys = returnKeys;
    }
}
