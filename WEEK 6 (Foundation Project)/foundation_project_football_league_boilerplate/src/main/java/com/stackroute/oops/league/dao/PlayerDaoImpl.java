package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerAlreadyExistsException;
import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

/**
 * This class is implementing the PlayerDao interface This class has one field
 * playerList and a String constant for storing file name
 */
public class PlayerDaoImpl implements PlayerDao {
    private static final String PLAYER_FILE_NAME = "src/main/resources/player.csv";
    private List<Player> playerList;

    /**
     * Constructor to initialize an empty ArrayList for playerList
     */
    public PlayerDaoImpl() {
        playerList = new ArrayList<Player>(); // * marks imp
    }

    /**
     * Return true if player object is stored in "player.csv" as comma separated
     * fields successfully when password length is greater than six and yearExpr is
     * greater than zero
     */
    @Override
    public boolean addPlayer(Player player) throws PlayerAlreadyExistsException {

        boolean flag = false;

        Player addedPlayer = null;
        try {
            addedPlayer = findPlayer(player.getPlayerId());
        } catch (PlayerNotFoundException e) {
            e.printStackTrace();
        }
        if (addedPlayer != null)
            throw new PlayerAlreadyExistsException();

        if (player.getPassword().length() > 6 && player.getYearExpr() > 0) {
            try {
                FileWriter write = new FileWriter(PLAYER_FILE_NAME, true);
                write.append(player.getPlayerId() + ", " + player.getPlayerName() + ", " + player.getPassword() + ", "
                        + player.getYearExpr() + ", " + player.getTeamTitle() + "\n"); //
                write.close();
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return flag;
    }

    // Return the list of player objects by reading data from the file "player.csv"
    @Override
    public List<Player> getAllPlayers() {
        List<Player> playersDetails = new ArrayList<>();
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(PLAYER_FILE_NAME))) {

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");
                Player player = new Player(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
                player.setTeamTitle(arr[4]);
                playerList.add(player);
                playersDetails.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(playersDetails);

        return playersDetails;
    }

    /**
     * Return Player object given playerId to search
     */
    @Override
    public Player findPlayer(String playerId) throws PlayerNotFoundException {
        if (playerId == null || playerId == "" || playerId == "  ")
            throw new PlayerNotFoundException();

        List<Player> pList = getAllPlayers();
        Player player = null;
        for (Player p : pList) {
            if (p.getPlayerId().equals(playerId)) {
                player = new Player(p.getPlayerId(), p.getPlayerName(), p.getPassword(), p.getYearExpr());
                player.setTeamTitle(p.getTeamTitle());
            }
        }
        if (player == null) {
            throw new PlayerNotFoundException();
        }
        return player;

    }
}
