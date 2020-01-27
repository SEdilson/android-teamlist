package com.example.teamlist;

import android.app.Application;

import com.example.teamlist.dao.TeamDAO;
import com.example.teamlist.models.Team;

public class TeamListApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        createTestTeams();
    }

    private void createTestTeams() {
        TeamDAO dao = new TeamDAO();
        dao.saveTeam(new Team("Dodgers", "National League", "West", 6));
        dao.saveTeam(new Team("Cubs", "National League", "Central", 3));
    }
}
