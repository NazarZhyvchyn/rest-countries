package com.example.restcountries.model;

public class Country {
    public String fullName;
    public String capital;
    public String continents;
    public String currentTime;

    public Country(String fullName, String capital, String continents, String currentTime) {
        this.fullName = fullName;
        this.capital = capital;
        this.continents = continents;
        this.currentTime = currentTime;
    }

    public Country() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return
                "{" + "fullName: '" + fullName + "," + '\n' +
                        "capital: '" + capital + "," + '\n' +
                        "continents: '" + continents + "," + '\n' +
                        "currentTime: '" + currentTime +  "}";
    }
}
