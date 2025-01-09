package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "programs") // Replace "programs" with your actual database table name
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    @Column(name = "id")
    private Long id; // Add an ID field to uniquely identify each program

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "program_description")
    private String programDescription;

    @Column(name = "image_url")
    private String imageUrl;

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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", programName='" + programName + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", programDescription='" + programDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
