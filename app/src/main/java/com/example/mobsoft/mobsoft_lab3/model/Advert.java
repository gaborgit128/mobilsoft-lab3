package com.example.mobsoft.mobsoft_lab3.model;

import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Table
public class Advert {

    private User user;

    private String title;

    private Integer cost;

    private String description;

    private Integer id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
