package com.stackroute.oops.league.dao;

import com.stackroute.oops.league.exception.PlayerNotFoundException;
import com.stackroute.oops.league.model.Player;
import com.stackroute.oops.league.model.PlayerTeam;

import java.util.Set;

public interface PlayerTeamDao {
    Set<PlayerTeam> getPlayerSetByTeamTitle(String teamTitle);

    boolean addPlayerToTeam(Player player) throws PlayerNotFoundException;

    Set<PlayerTeam> getAllPlayerTeams();
}
