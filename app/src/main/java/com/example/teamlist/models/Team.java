package com.example.teamlist.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Team implements Serializable {

    private int id = 0;
    private String name;
    private String league;
    private String division;
    private int numberOfTitles;
    private String image;

    public Team(String name, String league, String division, int numberOfTitles, String image) {
        this.name = name;
        this.league = league;
        this.division = division;
        this.numberOfTitles = numberOfTitles;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getLeague() {
        return league;
    }

    public String getDivision() {
        return division;
    }

    public int getNumberOfTitles() {
        return numberOfTitles;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setNumberOfTitles(int numberOfTitles) {
        this.numberOfTitles = numberOfTitles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    public boolean hasValidId() {
        return id > 0;
    }
}
