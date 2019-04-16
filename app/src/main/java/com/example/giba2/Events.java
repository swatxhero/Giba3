package com.example.giba2;

public class Events {
    private String eName;
    private String eDate;
    private String eTime;
    private String eLocation;
    private String eDescription;
    private int eNumVolunteers;

    public Events() {
    }

    public Events(String name, String date, String time,
                  String location, String description, int numVolunteers) {
        this.eName = name;
        this.eDate = date;
        this.eTime = time;
        this.eLocation = location;
        this.eDescription = description;
        this.eNumVolunteers = numVolunteers;
    }

    public String getName() {
        return this.eName;
    }

    public void setName(String name) {
        this.eName = name;
    }

    public String getDate() {
        return this.eDate;
    }

    public void setDate(String date) {
        this.eDate = date;
    }

    public String getTime() {
        return this.eTime;
    }

    public void setTime(String time) {
        this.eTime = time;
    }

    public String getLocation() {
        return this.eLocation;
    }

    public void setLocation(String location) {
        this.eLocation = location;
    }

    public String getDescription() {
        return this.eDescription;
    }

    public void setDescription(String description) {
        this.eDescription = description;
    }

    public int geteNumVolunteers() {
        return this.eNumVolunteers;
    }

    public void seteNumVolunteers(int numVolunteers) {
        this.eNumVolunteers = numVolunteers;
    }
}

