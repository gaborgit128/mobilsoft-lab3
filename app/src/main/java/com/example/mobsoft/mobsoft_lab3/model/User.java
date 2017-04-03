package com.example.mobsoft.mobsoft_lab3.model;

import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Table
public class User {

    private String username;

    private Integer id;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
