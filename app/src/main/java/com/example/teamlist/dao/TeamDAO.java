package com.example.teamlist.dao;

import com.example.teamlist.models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    private final static List<Team> teams = new ArrayList<>();
    private static int contadorIds = 1;

    public void saveTeam(Team team) {
        team.setId(contadorIds);
        teams.add(team);
        updateId();
    }

    private int updateId() {
        return contadorIds++;
    }

    public void updateTeam(Team team) {
        Team teamRetrieved = getTeamById(team);
        if(teamRetrieved != null) {
            int teamPosition = teams.indexOf(teamRetrieved);
            teams.set(teamPosition, team);
        }
    }

    public void removeTeam(Team team) {
        Team teamReturned = getTeamById(team);
        if(teamReturned != null) {
            teams.remove(teamReturned);
        }
    }

    public List<Team> allTeams() {
        return new ArrayList<>(teams);
    }

    public Team getTeamById(Team team) {
        for (Team t:teams) {
            if(t.getId() == team.getId()) {
                return t;
            }
        }
        return null;
    }

}
