package com.stackroute.oops.league.model;

import java.time.Year;

/**
 * This class contains five fields playerId,playerName,password,yearExpr and
 * teamTitle It is a subclass of Comparable interface
 */
public class Player extends Thread implements Comparable {
    // Parameterized Constructor to initialize all properties
    String playerId;
    String playerName;
    String password;
    int yearExpr;
    String teamTitle;

    public Player(String playerId, String playerName, String password, int yearExpr) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.password = password;
        this.yearExpr = yearExpr;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPassword() {
        return password;
    }

    public int getYearExpr() {
        return yearExpr;
    }

    // Return teamTitle if it is present and not empty
    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        if (checkTeamTitle() == false) {
            this.teamTitle = teamTitle;
        } else {
            this.teamTitle = null;
        }
    }

    public boolean checkTeamTitle() {
        if (this.teamTitle == "" || this.teamTitle == null)
            return false;
        else
            return true;
    }

    /**
     * This overridden method should return player details in below format
     * Player{playerId=xxxxx, playerName=xxxxxx,
     * yearExpr=xxxxxx,teamTitle=xxxxxxxx}-> if league team title is set
     * Player{playerId=xxxxx, playerName=xxxxxx, yearExpr=xxxxxx}-> if league team
     * title not set
     */

    @Override
    public String toString() {

        if (checkTeamTitle() == true) {
            return "Player{playerId=" + playerId + ", playerName=" + playerName + ", yearExpr=" + yearExpr
                    + ", teamTitle=" + teamTitle + "}";
        } else {
            return "Player{playerId=" + playerId + ", playerName=" + playerName + ", yearExpr=" + yearExpr + "}";
        }

    }

    // Overridden equals method
    @Override
    public boolean equals(Object object) {
        return false;
    }

    // Overridden hashcode method
    @Override
    public int hashCode() {
        return 0;
    }

    // compares player object based on playerId
    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
