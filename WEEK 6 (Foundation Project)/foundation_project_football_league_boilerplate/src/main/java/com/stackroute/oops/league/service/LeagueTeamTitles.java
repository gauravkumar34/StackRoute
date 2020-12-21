package com.stackroute.oops.league.service;

/**
 * Enum to store the four team titles Contains one field description and a
 * parameterized constructor to initialize it Modify this code by adding
 * description to each enum constants
 */
public enum LeagueTeamTitles {
    HIPHOP("Hiphop"), WIN2WIN("Win2Win"), HAPPYFEET("Happy Feet"), LUCKYSTRIKE("Lucky Strike");

    String teamValue;

    private LeagueTeamTitles(String teamValue) {
        this.teamValue = teamValue;
    }

    public String getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(String teamValue) {
        this.teamValue = teamValue;
    }

}
