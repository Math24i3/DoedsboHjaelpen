package com.system.model;

import javax.persistence.*;

@Entity
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproperty_type")
    private int id;

    @Column(name = "type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
