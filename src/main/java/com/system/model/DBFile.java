package com.system.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "assigment_images")
public class DBFile {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "image_id")
    private String id;

    private String name;

    private String address;
    @Lob
    private Byte[] data;


    public DBFile(String name, String fileType, Byte[] data) {
        this.name = name;
        this.data = data;
    }

    public DBFile(String name, Byte[] data) {
        this.name = name;
        this.data = data;
    }


    public DBFile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
