package com.system.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "assignment_task")
public class AssignmentTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassignments_task")
    private int id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idassignments", referencedColumnName = "idassignments")
    Assignment assignment;



    public AssignmentTasks(int stove) {
        this.stove = stove;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStove() {
        return stove;
    }

    public void setStove(int stove) {
        this.stove = stove;
    }


    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
