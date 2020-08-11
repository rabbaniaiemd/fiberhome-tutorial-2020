package com.fiberhome.tutorial.model;

public class Employee {
    private String id;
    private String name;
    private String designation;
    private String role;

    public Employee() {
    }

    public Employee(String name, String designation, String role) {
        this.name = name;
        this.designation = designation;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
