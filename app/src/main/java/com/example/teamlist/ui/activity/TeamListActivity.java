package com.example.teamlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teamlist.R;
import com.example.teamlist.models.Team;
import com.example.teamlist.ui.TeamListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.teamlist.ui.activity.TeamKeys.TEAM_KEY;

public class TeamListActivity extends AppCompatActivity {

    private static final String TEAM_LIST_TITLE_APPBAR = "Team List";
    private TeamListView teamListview = new TeamListView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        setTitle(TEAM_LIST_TITLE_APPBAR);
        configureTeamList();
        chargeButtonAddTeamActivity();
    }

    private void chargeButtonAddTeamActivity() {
        FloatingActionButton fabNewTeam = findViewById(R.id.activity_team_list_add_team_fab);
        fabNewTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToAddTeamActivity();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_team_list_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_team_list_menu_remove) {
            teamListview.confirmRemove(item);
        }
        return super.onContextItemSelected(item);
    }

    private void changeToAddTeamActivity() {
        startActivity(new Intent(this,
                AddTeamActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        teamListview.updateTeams();
    }

    private void configureTeamList() {
        ListView teams_listview = findViewById(R.id.teams_listview);
        teamListview.configureAdapter(teams_listview);
        configureListenerToUpdateTeam(teams_listview);
        registerForContextMenu(teams_listview);
    }

    private void configureListenerToUpdateTeam(ListView teams_listview) {
        teams_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Team teamRetrieved = (Team) adapterView.getItemAtPosition(position);
                openFormToUpdateTeam(teamRetrieved);
            }
        });
    }

    private void openFormToUpdateTeam(Team teamRetrieved) {
        Intent goToFormUpdateTeam = new Intent(this,
                AddTeamActivity.class);
        goToFormUpdateTeam.putExtra(TEAM_KEY, teamRetrieved);
        startActivity(goToFormUpdateTeam);
    }

}
