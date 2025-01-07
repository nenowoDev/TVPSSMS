
package com.example.entity;

import java.util.Date;


public class Program {
    private String programName;
    private Date date;
    private String location;
    private String programDescription;
    private String imageUrl; // Assuming the image is stored as a URL or path

    // Constructors
    public Program() {
    }

    public Program(String programName, Date date, String location, String programDescription, String imageUrl) {
        this.programName = programName;
        this.date = date;
        this.location = location;
        this.programDescription = programDescription;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // ToString method
    @Override
    public String toString() {
        return "ProgramPlanning{" +
                "programName='" + programName + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", programDescription='" + programDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
