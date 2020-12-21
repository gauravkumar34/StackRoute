package com.stackroute.oops.league.test.dao;

import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.dao.PlayerDao;
import com.stackroute.oops.league.dao.PlayerDaoImpl;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerDaoImplTests {
    private static final String MESSAGE_ONE = "PlayerDaoImpl should be initialized with an empty LinkedList properly";
    private static final String MESSAGE_TWO = "Given valid player data should add player to database and return true";
    private static final String MESSAGE_THREE = "Given invalid or empty player id should throw exception";
    private static final String MESSAGE_FOUR = "Given Valid playerId should return the player object";
    private static final String MESSAGE_FIVE = "Given empty player repo when searched should throw exception";
    private static final String MESSAGE_SIX = "getAllPlayers should return player list of all players";
    private static PlayerDao playerDao;
    private static Player player;
    private static final String PLAYER_FILE_NAME = "src/main/resources/player.csv";

    @BeforeAll
    public static void setUp() throws Exception {
        playerDao = new PlayerDaoImpl();
        player = new Player("001", "praveen", "password", 7);
    }

    @AfterAll
    public static void tearDown() {
        player = null;
        playerDao = null;
    }

    @Test
    @Order(1)
    public void givenPlayerDaoObjectThenPlayerListSetAsArrayList() {
        assertThat(MESSAGE_ONE, playerDao.getAllPlayers(), is(empty()));
    }

    @Test
    @Order(2)
    public void givenPlayerDataWhenAddedThenReturnTrue() throws PlayerAlreadyExistsException {
        assertTrue(playerDao.addPlayer(player), MESSAGE_TWO);
    }

    @Test
    @Order(3)
    public void givenPlayerDataAddedThenReturnAllPlayers() {
        List<Player> expected = playerDao.getAllPlayers();
        System.out.println(expected.get(0));
        assertEquals(player.getPlayerId(), expected.get(0).getPlayerId(), MESSAGE_SIX);
    }

    @Test
    @Order(4)
    public void givenValidPlayerIdThenReturnPlayer() throws PlayerNotFoundException {
        Player expected = playerDao.findPlayer("001");
        assertEquals(player.getPlayerId(), expected.getPlayerId(), MESSAGE_FOUR);
    }

    @Test
    @Order(5)
    public void givenPlayerDetailsWhenUpdatedThenReturnTrue() {
        player.setTeamTitle("Hiphop");
    }

    @Test
    @Order(6)
    public void givenNonExistingOrEmptyPlayerIdThenThrowException() {
        assertThrows(PlayerNotFoundException.class, () -> playerDao.findPlayer("002"), MESSAGE_THREE);
        assertThrows(PlayerNotFoundException.class, () -> playerDao.findPlayer(""), MESSAGE_THREE);
    }

    @Test
    @Order(7)
    public void givenInValidPlayerIdThenReturnNull() {
        assertThrows(PlayerNotFoundException.class, () -> playerDao.findPlayer(""), MESSAGE_THREE);
        assertThrows(PlayerNotFoundException.class, () -> playerDao.findPlayer("  "), MESSAGE_THREE);
        assertThrows(PlayerNotFoundException.class, () -> playerDao.findPlayer(null), MESSAGE_THREE);
    }

    @Test
    @Order(8)
    public void givenAllPlayerDataDeletedWhenSearchedThenThrowException() throws FileNotFoundException {
        new PrintWriter(PLAYER_FILE_NAME).close();
        assertThrows(PlayerNotFoundException.class, () -> playerDao.findPlayer("001"), MESSAGE_FIVE);
    }

}