package com.company.model;

import java.io.Serializable;

public class StudentModel implements Serializable {

    private String username;
    private String password;
    private String classes;
    private String balance;
    private String grade;
    private String date;

    public StudentModel(String username, String password, String classes, String balance, String grade, String date) {
        this.username = username;
        this.password = password;
        this.classes = classes;
        this.balance = balance;
        this.grade = grade;
        this.date = date;
    }

    @Override
    public String toString() {
        return
                "Student:" +
                        "username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", classes'" + classes + '\'' +
                        ", balance='" + balance + '\'' +
                        ", grade='" + grade + '\'' +
                        ", date='" + date + '\'';
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public String getClasses() {
        return classes;
    }

    public String getBalance() {
        return balance;
    }

    public String getGrade() {
        return grade;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}



