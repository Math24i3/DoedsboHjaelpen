package com.system.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "assignment_tasks")
public class AssignmentTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassignment_tasks")
    private int id;

    @Column(name = "stove", columnDefinition = "BOOLEAN")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean stove = false;

    @Column(name = "fridge", columnDefinition = "BOOLEAN")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean fridge =false;

    @Column (name = "washingMachine", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean washingMachine = false;

    @Column (name = "dishWasher", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean dishWasher = false;

    @Column(name = "carpets", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean carpets = false;

    @Column (name = "carpetTape", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean carpetTape = false;

    @Column (name = "boltsAndScrews", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean boltsAndScrews = false;

    @Column (name = "curtains", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean curtains = false;

    @Column(name = "curtainrod", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean curtainrod = false;

    @Column (name = "blinds", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean blinds = false;

    @Column (name = "lamps", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean lamps = false;

    @Column (name = "paintings", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean paintings = false;

    @Column (name = "documents", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean documents = false;

    @Column (name = "keys", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean keys = false;

    @Column (name = "cellarAndLoft", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean cellarAndLoft = false;

    @Column (name = "cleaningService", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean cleaningService = false;

    @Column(name = "accessibilityTools", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")

    private boolean accessibilityTools = false;

    @Column (name = "returnKeys", columnDefinition = "TINYINT", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean returnKeys = false;

    @OneToOne(cascade = CascadeType.ALL)
    Assignment assignment;

    public AssignmentTasks(boolean stove, boolean fridge, boolean washingMachine, boolean dishWasher, boolean carpets, boolean carpetTape, boolean boltsAndScrews, boolean curtains, boolean curtainrod, boolean blinds, boolean lamps, boolean paintings, boolean documents, boolean keys, boolean cellarAndLoft, boolean cleaningService, boolean accessibilityTools, boolean returnKeys) {
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
    }

    public AssignmentTasks(boolean stove) {
        this.stove = stove;
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

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
