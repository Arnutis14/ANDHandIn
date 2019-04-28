package com.example.exercise41;

public class State {

    private String name;
    private String abbreviation;

    public State(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
