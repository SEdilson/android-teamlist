package com.example.teamlist.asynctask;

import com.example.teamlist.database.dao.RoomTeamDAO;
import com.example.teamlist.models.Team;

public class EditTeamTask extends TeamListBase {

    private RoomTeamDAO dao;
    private Team team;
    private EditTeamListener listener;

    public EditTeamTask(RoomTeamDAO dao, Team team, EditTeamListener listener) {
        this.dao = dao;
        this.team = team;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.change(team);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.editTeam();
    }

    public interface EditTeamListener {
        void editTeam();
    }
}
