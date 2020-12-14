package com.company.model;

import java.io.Serializable;

public class AdminModel implements Serializable {

    private String username;
    private String password;
    private String date;

    public AdminModel (String username, String password, String date) {
        this.username = password;
        this.password =password;
        this.date = date;
    }

    @Override
    public String toString() {
        return
                "Admin :" +
                "username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", date='" + date + '\'';
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

