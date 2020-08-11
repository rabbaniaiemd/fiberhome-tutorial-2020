package com.fiberhome.model;

public class EmployeeInformation {

    private String name;
    private String city;
    private String designation;

    public EmployeeInformation(String name, String city, String designation) {
        this.name = name;
        this.city = city;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
