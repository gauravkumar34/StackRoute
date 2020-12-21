package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements the PlayerTeamDao interface This class has two fields
 * playerTeamSet,playerDao and a String constant for storing file name.
 */
public class PlayerTeamDaoImpl implements PlayerTeamDao {
    private static final String TEAM_FILE_NAME = "src/main/resources/finalteam.csv";
    PlayerDao playerDao;
    TreeSet<PlayerTeam> playerTeams;

    /**
     * Constructor to initialize an empty TreeSet and PlayerDao object
     */
    public PlayerTeamDaoImpl() {
        playerTeams = new TreeSet<PlayerTeam>();
        playerDao = new PlayerDaoImpl();

    }

    /*
     * Returns the list of players belonging to a particular teamTitle by reading
     * from the file finalteam.csv
     */
    @Override
    public Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle) {
        if (teamTitle != null) {
            String line = null;
            try (BufferedReader br = new BufferedReader(new FileReader(TEAM_FILE_NAME))) {
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(", ");
                    if (line.contains(teamTitle)) {
                        for (int i = 0; i < str.length; i++) {
                            PlayerTeam plr = new PlayerTeam(str[0], str[4]);
                            playerTeams.add(plr);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return playerTeams;
    }

    // Add he given PlayerTeam Object to finalteam.csv file
    @Override
    public boolean addPlayerToTeam(Player player) throws PlayerNotFoundException {
        Player find = null;
        try {
            find = playerDao.findPlayer(player.getPlayerId());
        } catch (PlayerNotFoundException e) {
            e.printStackTrace();
        }
        if (find != null) {
            try {
                FileWriter w = new FileWriter(TEAM_FILE_NAME);
                w.append(player.getPlayerId() + ", " + player.getPlayerName() + ", " + player.getPassword() + ", "
                        + player.getYearExpr() + ", " + player.getTeamTitle() + "\n");
                w.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new PlayerNotFoundException();
        }
        return false;
    }

    // Return the set of all PlayerTeam by reading the file content from
    // finalteam.csv file
    @Override
    public Set<PlayerTeam> getAllPlayerTeams() {
        playerTeams.clear();
        String line = null;
        Set<PlayerTeam> playerTeam = new TreeSet<PlayerTeam>();
        try (BufferedReader br = new BufferedReader(new FileReader(TEAM_FILE_NAME))) {
            while ((line = br.readLine()) != null) {
                String[] str = line.split(", ");
                PlayerTeam plr = new PlayerTeam(str[0], str[1]);
                playerTeam.add(plr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerTeam;
    }
}
