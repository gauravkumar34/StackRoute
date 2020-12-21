package com.stackroute.oops.league.service;

import com.stackroute.oops.league.dao.PlayerDao;
import com.stackroute.oops.league.dao.PlayerTeamDao;
import com.stackroute.oops.league.exception.PlayerAlreadyAllottedException;
import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.exception.TeamAlreadyFormedException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements leagueTeamService This has four fields: playerDao,
 * playerTeamDao and registeredPlayerList and playerTeamSet
 */
public class LeagueTeamServiceImpl implements LeagueTeamService {

    PlayerDao playerDao;
    PlayerTeamDao playerTeamDao;
    List<Player> registeredPlayerList;
    Set<PlayerTeam> playersTeam;

    /**
     * Constructor to initialize playerDao, playerTeamDao empty ArrayList for
     * registeredPlayerList and empty TreeSet for playerTeamSet
     */

    public LeagueTeamServiceImpl() {
        registeredPlayerList = new ArrayList<>();
        playersTeam = new TreeSet<>();
    }

    // Add player data to file using PlayerDao object
    @Override
    public boolean addPlayer(Player player) throws PlayerAlreadyExistsException {
        playerDao.addPlayer(player);
        return true;
    }

    /**
     * Register the player for the given teamTitle Throws PlayerNotFoundException if
     * the player does not exists Throws PlayerAlreadyAllottedException if the
     * player is already allotted to team Throws TeamAlreadyFormedException if the
     * maximum number of players has reached for the given teamTitle Returns null if
     * there no players available in the file "player.csv" Returns "Registered" for
     * successful registration Returns "Invalid credentials" when player credentials
     * are wrong
     */
    @Override
    public synchronized String registerPlayerToLeague(String playerId, String password, LeagueTeamTitles teamTitle)
            throws PlayerNotFoundException, TeamAlreadyFormedException, PlayerAlreadyAllottedException {

        Player player = playerDao.findPlayer(playerId);

        if (playerDao.getAllPlayers().isEmpty())
            return null;

        if (!player.getPassword().equals(password))
            return "Invalid credentials";

        playersTeam = playerTeamDao.getAllPlayerTeams();
        PlayerTeam playerTeam = new PlayerTeam(playerId, teamTitle.getTeamValue());
        if (playersTeam.contains(playerTeam))
            throw new PlayerAlreadyAllottedException();

        player.setTeamTitle(teamTitle.getTeamValue());

        registeredPlayerList.add(player);

        System.out.println(registeredPlayerList);
        return "Registered";
    }

    /**
     * Return the list of all registered players
     */
    @Override
    public List<Player> getAllRegisteredPlayers() {
        return registeredPlayerList;
    }

    /**
     * Return the existing number of players for the given title
     */
    @Override
    public int getExistingNumberOfPlayersInTeam(LeagueTeamTitles teamTitle) {

        return playerTeamDao.getPlayerSetByTeamTitle(teamTitle.getTeamValue()).size();

    }

    /**
     * Admin credentials are authenticated and registered players are allotted to
     * requested teams if available If the requested teams are already formed,admin
     * randomly allocates to other available teams PlayerTeam object is added to
     * "finalteam.csv" file allotted by the admin using PlayerTeamDao Return "No
     * player is registered" when registeredPlayerList is empty Throw
     * TeamAlreadyFormedException when maximum number is reached for all teams
     * Return "Players allotted to teams" when registered players are successfully
     * allotted Return "Invalid credentials for admin" when admin credentials are
     * wrong
     */
    @Override
    public String allotPlayersToTeam(String adminName, String password, LeagueTeamTitles teamTitle)
            throws TeamAlreadyFormedException, PlayerNotFoundException {
        int count = 0;
        if (!(AdminCredentials.admin.equals(adminName) && AdminCredentials.password.equals(password)))
            return "Invalid credentials for admin";

        // registeredPlayerList = getAllRegisteredPlayers(); //!error mark
        List<Player> playerList = playerDao.getAllPlayers();
        if (registeredPlayerList.isEmpty())
            return "No player is registered";

        for (Player p : playerList) {
            if (p.getTeamTitle() == null)
                continue;
            if (p.getTeamTitle().equals(teamTitle.getTeamValue())) {
                count++;

            }

        }
        if (count == 11) {
            throw new TeamAlreadyFormedException();
        }

        System.out.println(registeredPlayerList.size());
        for (Player p : registeredPlayerList) {
            if (p.getTeamTitle() == null) {
                p.setTeamTitle(teamTitle.getTeamValue());
                playerTeamDao.addPlayerToTeam(p);

            }

        }
        // System.out.println(count);

        return "Players allotted to teams";
    }

    /**
     * static nested class to initialize admin credentials admin name='admin' and
     * password='pass'
     */
    static class AdminCredentials {
        private static String admin = "admin";
        private static String password = "pass";
    }
}
