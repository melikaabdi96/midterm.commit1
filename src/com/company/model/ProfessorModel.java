package com.company.model;

import java.io.Serializable;

public class ProfessorModel implements Serializable {

    private String username;
    private String password;
    private String classes;
    private String students;
    private String date;

    public ProfessorModel(String username, String password, String classes, String students, String date) {
        this.username = username;
        this.password = password;
        this.classes = classes;
        this.students = students;
        this.date = date;
    }

    @Override
    public String toString() {
        return
                "Professor:" +
                "username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", classes'" + classes + '\'' +
                        ", students='" + students + '\'' +
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

    public String getStudents() {
        return students;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}


