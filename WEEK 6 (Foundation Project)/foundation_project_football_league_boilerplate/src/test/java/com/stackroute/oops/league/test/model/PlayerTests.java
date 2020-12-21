package com.stackroute.oops.league.test.model;

import com.stackroute.oops.league.model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
    private static final String MESSAGE_ONE = "Player object should be initialized with properties";
    private static final String MESSAGE_TWO = "Player details should be properly displayed";
    private static final String MESSAGE_THREE = "League title should not be null or empty. Give proper value to set";
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("001", "Karthik", "Password", 12);
    }

    @AfterEach
    public void tearDown() {
        player = null;
    }

    @Test
    public void givenPlayerObjectThenShouldSetProperties() { // *getter setter
        assertEquals("001", player.getPlayerId(), MESSAGE_ONE);
        assertEquals("Karthik", player.getPlayerName(), MESSAGE_ONE);
        assertEquals("Password", player.getPassword(), MESSAGE_ONE);
        assertEquals(12, player.getYearExpr(), MESSAGE_ONE);
    }

    @Test
    public void givenPlayerObjectThenReturnPlayerDetails() { // *toString
        String expected = "Player{playerId=001, playerName=Karthik, yearExpr=12}";
        assertEquals(player.toString().toLowerCase(), expected.toLowerCase(), MESSAGE_TWO);
        player.setTeamTitle("Hiphop");
        expected = "Player{playerId=001, playerName=Karthik, yearExpr=12, teamTitle=Hiphop}";
        assertEquals(player.toString().toLowerCase(), expected.toLowerCase(), MESSAGE_TWO);

    }

    @Test
    public void givenPlayerObjectWhenLeagueTitleSetThenAddNewLeagueTitleProperty() {
        player.setTeamTitle("Hiphop");
        assertEquals("Hiphop", player.getTeamTitle(), MESSAGE_THREE);
        player.setTeamTitle("");
        assertEquals(null, player.getTeamTitle(), MESSAGE_THREE);
        player.setTeamTitle(null);
        assertEquals(null, player.getTeamTitle(), MESSAGE_THREE);
    }
}
