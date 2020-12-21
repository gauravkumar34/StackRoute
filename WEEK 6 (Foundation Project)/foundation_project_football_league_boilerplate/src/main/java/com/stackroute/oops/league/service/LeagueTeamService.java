package com.stackroute.oops.league.service;


import com.stackroute.oops.league.exception.*;
import com.stackroute.oops.league.model.Player;

import java.util.List;

public interface LeagueTeamService {
    boolean addPlayer(Player player) throws PlayerAlreadyExistsException;

    String registerPlayerToLeague(String playerId, String password, LeagueTeamTitles teamTitle)
            throws PlayerNotFoundException, TeamAlreadyFormedException,  PlayerAlreadyAllottedException;

    List<Player> getAllRegisteredPlayers();

    int getExistingNumberOfPlayersInTeam(LeagueTeamTitles teamTitle);

    String allotPlayersToTeam(String adminName, String password, LeagueTeamTitles teamTitle)
            throws TeamAlreadyFormedException,  PlayerNotFoundException;
}
