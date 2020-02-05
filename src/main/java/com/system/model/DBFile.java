package com.system.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "assigment_images")
public class DBFile {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "image_id")
    private String id;

    private String name;

    private byte[] data;


    public DBFile(String name, String fileType, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public DBFile(String name, byte[] data) {
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


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
