package com.example.teamlist.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Team implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String name;
    private String league;
    private String division;
    private int numberOfTitles;
    private int image;

    @Ignore
    public Team(String name, String league, String division, int numberOfTitles, int image) {
        this.name = name;
        this.league = league;
        this.division = division;
        this.numberOfTitles = numberOfTitles;
        this.image = image;
    }

    public Team() {

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
