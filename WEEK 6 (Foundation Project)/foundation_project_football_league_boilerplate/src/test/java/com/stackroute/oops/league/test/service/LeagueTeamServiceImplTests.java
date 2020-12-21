package com.stackroute.oops.league.test.service;

import com.stackroute.oops.league.dao.PlayerDao;
import com.stackroute.oops.league.dao.PlayerTeamDao;
import com.stackroute.oops.league.exception.PlayerAlreadyAllottedException;
import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.exception.TeamAlreadyFormedException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;
import com.stackroute.oops.league.service.LeagueTeamServiceImpl;
import com.stackroute.oops.league.service.LeagueTeamTitles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LeagueTeamServiceImplTests {
    private static final String MESSAGE_PLAYER_ADDED = "Given player data when added should return true";
    private static final String MESSAGE_REGISTERED_LIST = " Given valid player and league details should register player to league";
    private static final String MESSAGE_NULL_STRING = "Given empty player repo when player try to register should return null";
    private static final String MESSAGE_PLAYER_NOT_FOUND_EXCEPTION = "Given invalid player data to register should throw exception";
    private static final String MESSAGE_PLAYER_ALREADY_ALLOTTED_EXCEPTION = " Cannot register, Player is already allotted to team";
    private static final String MESSAGE_EMPTY_REGISTERED_LIST = "Given player repo and no player registered should return empty list";
    private static final String MESSAGE_AUTHENTICATED = "Cannot register, player has given invalid credentials";
    private static final String MESSAGE_TEAM_ALLOTTED = "Given proper admin credentials should allot player to league team";
    private static final String MESSAGE_TEAM_MAXIMUM = "Maximum number of players in a single team should not exceed 11";
    List<Player> playerList;
    Set<PlayerTeam> playerTeamSet;
    private Player playerOne, playerTwo, playerTemp;
    private PlayerTeam playerTeamOne,playerTeamTwo;

    @Mock
    private PlayerTeamDao playerTeamDao;
    @Mock
    private PlayerDao playerDao;

    @InjectMocks
    private LeagueTeamServiceImpl leagueTeamService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        playerList = new ArrayList<>();
        playerOne = new Player("001", "praveen", "password", 7);
        playerTwo = new Player("002", "kumar", "password", 5);
        playerList.add(playerOne);
        playerList.add(playerTwo);
        playerTeamSet=new TreeSet<>();
        playerTeamOne=new PlayerTeam("001","Hiphop");
        playerTeamTwo=new PlayerTeam("002","Win2Win");
        playerTeamSet.add(playerTeamOne);
        playerTeamSet.add(playerTeamTwo);
    }

    @AfterEach
    public void tearDown() {
        leagueTeamService = null;
    }

    @Test
    public void givenLeagueTeamServiceWhenPlayerAddedThenReturnTrue() throws PlayerAlreadyExistsException {
        when(playerDao.addPlayer(playerOne)).thenReturn(true);
        assertTrue(leagueTeamService.addPlayer(playerOne), MESSAGE_PLAYER_ADDED);
    }

    @Test
    public void givenPlayerCredentialsWhenRegisteredThenReturnResultString() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        when(playerDao.findPlayer("002")).thenReturn(playerTwo);
        String actual = leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        assertEquals("Registered", actual, MESSAGE_REGISTERED_LIST);
        actual = leagueTeamService.registerPlayerToLeague("002", "password", LeagueTeamTitles.WIN2WIN);
        assertEquals("Registered", actual, MESSAGE_REGISTERED_LIST);
    }

    @Test
    public void givenInValidPlayerDataWhenRegisterThenThrowException() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("100")).thenThrow(PlayerNotFoundException.class);
        when(playerDao.findPlayer(null)).thenThrow(PlayerNotFoundException.class);
        when(playerDao.findPlayer("")).thenThrow(PlayerNotFoundException.class);
        assertThrows(PlayerNotFoundException.class,
                () -> leagueTeamService.registerPlayerToLeague("100", "password", LeagueTeamTitles.HIPHOP), MESSAGE_PLAYER_NOT_FOUND_EXCEPTION);
        assertThrows(PlayerNotFoundException.class,
                () -> leagueTeamService.registerPlayerToLeague("", "password", LeagueTeamTitles.HIPHOP), MESSAGE_PLAYER_NOT_FOUND_EXCEPTION);
        assertThrows(PlayerNotFoundException.class,
                () -> leagueTeamService.registerPlayerToLeague(null, "password", LeagueTeamTitles.HIPHOP), MESSAGE_PLAYER_NOT_FOUND_EXCEPTION);
    }

    @Test
    public void givenPlayerDataToRegisterWhenAlreadyAllottedThenThrowsException() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        when(playerTeamDao.getAllPlayerTeams()).thenReturn(playerTeamSet);
        assertThrows(PlayerAlreadyAllottedException.class,
                () -> leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.WIN2WIN),
                MESSAGE_PLAYER_ALREADY_ALLOTTED_EXCEPTION);
    }

    @Test
    public void givenEmptyPlayerWhenPlayerRegisteredThenReturnNull() throws Exception {
        playerList.clear();
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        String actual = leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        assertNull(actual, MESSAGE_NULL_STRING);
    }

    @Test
    public void givenLeagueTeamServiceWhenPlayerRegisteredThenReturnAllRegisteredPlayers() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        List<Player> registeredList = leagueTeamService.getAllRegisteredPlayers();
        assertThat(MESSAGE_REGISTERED_LIST, registeredList.size(), is(equalTo(1)));
        assertEquals("001", registeredList.get(0).getPlayerId(), MESSAGE_REGISTERED_LIST);
    }

    @Test
    public void givenLeagueServiceWhenNoPlayerRegisteredThenReturnRegisteredList() {
        List<Player> registeredList = leagueTeamService.getAllRegisteredPlayers();
        assertThat(MESSAGE_EMPTY_REGISTERED_LIST, registeredList.size(), is(equalTo(0)));
    }

    @Test
    public void givenPlayerDataWhenAuthenticationFailsThenReturnEmptyList() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        String actual = leagueTeamService.registerPlayerToLeague("001", "pass", LeagueTeamTitles.HIPHOP);
        assertEquals("Invalid credentials", actual, MESSAGE_AUTHENTICATED);
    }

    @Test
    public void givenAdminCredentialsAndLeagueTitleThenPlayersAreAllotted() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        when(playerDao.findPlayer("002")).thenReturn(playerTwo);
        when(playerTeamDao.addPlayerToTeam(playerOne)).thenReturn(true);
        when(playerTeamDao.addPlayerToTeam(playerTwo)).thenReturn(true);
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        leagueTeamService.registerPlayerToLeague("002", "password", LeagueTeamTitles.HIPHOP);
        String expected = leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.HIPHOP);
        assertEquals(expected.toLowerCase(), "Players allotted to teams".toLowerCase(), MESSAGE_TEAM_ALLOTTED);
    }

    @Test
    public void givenLeagueTitlesWhenSamePlayerRegisterMultipleTimesThenAllotted() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        when(playerTeamDao.addPlayerToTeam(playerOne)).thenReturn(true);
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.WIN2WIN);
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        String expected = leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.HIPHOP);
        assertEquals(expected.toLowerCase(), "Players allotted to teams".toLowerCase(), MESSAGE_TEAM_ALLOTTED);
    }

    @Test
    public void givenAdminCredentialsAndLeagueTitleThenAllotPlayersForRespectiveTitles() throws Exception {
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        when(playerDao.findPlayer("001")).thenReturn(playerOne);
        when(playerDao.findPlayer("002")).thenReturn(playerTwo);
        when(playerTeamDao.addPlayerToTeam(playerOne)).thenReturn(true);
        when(playerTeamDao.addPlayerToTeam(playerTwo)).thenReturn(true);
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        leagueTeamService.registerPlayerToLeague("002", "password", LeagueTeamTitles.WIN2WIN);
        String expected = leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.HIPHOP);
        assertEquals(expected.toLowerCase(), "Players allotted to teams".toLowerCase(), MESSAGE_TEAM_ALLOTTED);
        expected = leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.WIN2WIN);
        assertEquals(expected.toLowerCase(), "Players allotted to teams".toLowerCase(), MESSAGE_TEAM_ALLOTTED);
    }


    @Test
    public void givenAdminCredentialsAndLeagueTitleWhenPlayersNotRegisteredThenReturnResultString() throws Exception {
        String expected = leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.HIPHOP);
        assertEquals(expected.toLowerCase(), "No player is registered".toLowerCase(), MESSAGE_TEAM_ALLOTTED);
    }

   @Test
    public void givenInvalidAdminCredentialsAndLeagueTitleThenReturnResultString() throws Exception {
        leagueTeamService.registerPlayerToLeague("001", "password", LeagueTeamTitles.HIPHOP);
        String expected = leagueTeamService.allotPlayersToTeam("admin", "password", LeagueTeamTitles.HIPHOP);
        assertEquals(expected.toLowerCase(), "Invalid credentials for admin".toLowerCase(), MESSAGE_TEAM_ALLOTTED);
    }

    @Test
    public void givenAllottedPlayersReachedMaximumLimitThenThrowException() throws Exception {
        addPlayersTestData();
        playerTemp = new Player("013", "Kamal", "password", 4);
        when(playerDao.findPlayer("013")).thenReturn(playerTemp);
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        leagueTeamService.registerPlayerToLeague("013", "password", LeagueTeamTitles.HIPHOP);
        assertThrows(TeamAlreadyFormedException.class, () ->
                        leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.HIPHOP),
                MESSAGE_TEAM_MAXIMUM);

    }

    void addPlayersTestData() {
        playerList = new ArrayList<>();
        Player[] player = new Player[13];
        for (int i = 1; i < 13; i++) {
            if (i < 10) {
                player[i] = new Player("00" + i, "name" + i, "password", i + 1);
                player[i].setTeamTitle("Hiphop");
                playerList.add(player[i]);

            } else if (i < 12) {
                player[i] = new Player("0" + i, "name" + i, "password", i);
                player[i].setTeamTitle("Hiphop");
                playerList.add(player[i]);
            } else {
                player[i] = new Player("0" + i, "name" + i, "password", i);
                playerList.add(player[i]);
            }
        }
    }

    @Test
    public void givenAllottedPlayersWhenAllTeamsFormedThenThrowException() throws Exception {
        addAllPlayersTestData();
        playerTemp = new Player("045", "Kamal", "password", 4);
        when(playerDao.findPlayer("045")).thenReturn(playerTemp);
        when(playerDao.getAllPlayers()).thenReturn(playerList);
        leagueTeamService.registerPlayerToLeague("045", "password", LeagueTeamTitles.HAPPYFEET);
        assertThrows(TeamAlreadyFormedException.class, () ->
                        leagueTeamService.allotPlayersToTeam("admin", "pass", LeagueTeamTitles.HAPPYFEET),
                MESSAGE_TEAM_MAXIMUM);

    }

    void addAllPlayersTestData() {
        playerList = new ArrayList<>();
        Player[] player = new Player[45];
        for (int i = 1; i < 45; i++) {
            if (i < 10) {
                player[i] = new Player("00" + i, "name" + i, "password", i + 1);
                player[i].setTeamTitle("Hiphop");
                playerList.add(player[i]);

            } else if (i < 12) {
                player[i] = new Player("0" + i, "name" + i, "password", i);
                player[i].setTeamTitle("Hiphop");
                playerList.add(player[i]);
            } else if (i >= 12 && i <= 22) {
                player[i] = new Player("0" + i, "name" + i, "password", i - 10);
                player[i].setTeamTitle("Win2Win");
                playerList.add(player[i]);
            } else if (i >= 23 && i <= 33) {
                player[i] = new Player("0" + i, "name" + i, "password", i - 20);
                player[i].setTeamTitle("Happy Feet");
                playerList.add(player[i]);
            } else {
                player[i] = new Player("0" + i, "name" + i, "password", i - 30);
                player[i].setTeamTitle("Lucky Strike");
                playerList.add(player[i]);
            }
        }
    }
}