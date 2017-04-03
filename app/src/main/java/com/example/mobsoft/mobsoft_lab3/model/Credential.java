package com.example.mobsoft.mobsoft_lab3.model;

import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 03..
 */

@Table
public class Credential {

    private String username;

    private String password;

    public Credential(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
