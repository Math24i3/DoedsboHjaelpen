package com.system.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "notices")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotices")
    private int id;

    @Column(name = "auth_user_id")
    private int user;

    @Column(name = "date")
    private Date date;

    @Column(name = "message")
    private String message;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String str) {
        this.date = Date.valueOf(str);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
