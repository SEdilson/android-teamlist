package com.example.teamlist.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.teamlist.dao.TeamDAO;
import com.example.teamlist.models.Team;
import com.example.teamlist.ui.adapter.TeamListAdapter;

public class TeamListView {

    private final Context context;
    private final TeamListAdapter adapter;
    private final TeamDAO dao;

    public TeamListView(Context context) {
        this.context = context;
        adapter = new TeamListAdapter(this.context);
        dao = new TeamDAO();
    }

    public void confirmRemove(@NonNull final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removing Team")
                .setMessage("Are you sure that you wanna remove this team?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdapterView.AdapterContextMenuInfo menuInfo =
                                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Team teamRetrieved = adapter.getItem(menuInfo.position);
                        removeTeam(teamRetrieved);
                        configureConfirmationDialog();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void configureConfirmationDialog() {
        new AlertDialog
                .Builder(this.context)
                .setMessage("Team removed successfully")
                .setPositiveButton("OK", null)
                .show();
    }

    public void updateTeams() {
        this.adapter.updateView(dao.allTeams());
    }

    public void removeTeam(Team team) {
        adapter.remove(team);
        dao.removeTeam(team);
    }

    public void configureAdapter(ListView teams_listview) {
        teams_listview.setAdapter(this.adapter);
    }
}
