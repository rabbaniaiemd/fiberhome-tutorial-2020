package com.fiberhome.model;

public class StudentDetails {

    String name;
    String rollNumber;
    String course;
    String qualification;

    public StudentDetails(String name, String rollNumber, String course, String qualification) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
