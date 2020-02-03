package com.example.teamlist.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamlist.R;
import com.example.teamlist.dao.TeamDAO;
import com.example.teamlist.models.Team;
import com.example.teamlist.ui.recycler.adapter.TeamListAdapter;
import com.example.teamlist.ui.recycler.adapter.listener.OnItemClickListener;

import java.util.List;

import static com.example.teamlist.ui.activity.TeamKeys.INVALID_POSITION;
import static com.example.teamlist.ui.activity.TeamKeys.POSITION_KEY;
import static com.example.teamlist.ui.activity.TeamKeys.REQUEST_CODE_UPDATE_TEAM;
import static com.example.teamlist.ui.activity.TeamKeys.TEAM_KEY;

public class TeamListActivity extends AppCompatActivity {

    private static final String TEAM_LIST_TITLE_APPBAR = "Team List";
    TeamDAO dao = new TeamDAO();
    private List<Team> teams = dao.allTeams();
    private TeamListAdapter adapter = new TeamListAdapter(this, teams);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        setTitle(TEAM_LIST_TITLE_APPBAR);
        configureTeamList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(itsResultDetailTeam(requestCode, data)) {
            if(isResultCode(resultCode)) {
                Team retrievedTeam = (Team) data.getSerializableExtra(TEAM_KEY);
                int positionReturned = data.getIntExtra(POSITION_KEY, INVALID_POSITION);
                changeTeam(retrievedTeam, positionReturned);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void changeTeam(Team team, int position) {
        dao.change(position, team);
        adapter.change(position, team);
    }

    private boolean itsResultDetailTeam(int requestCode, @Nullable Intent data) {
        return isRequestCode(requestCode) && hasTeamKey(data);
    }

    private boolean hasTeamKey(@Nullable Intent data) {
        return data != null && data.hasExtra(TEAM_KEY);
    }

    private boolean isResultCode(int resultCode) {
        return resultCode == Activity.RESULT_OK;
    }

    private boolean isRequestCode(int requestCode) {
        return requestCode == REQUEST_CODE_UPDATE_TEAM;
    }

    private void configureTeamList() {
        RecyclerView teams_recyclerview = findViewById(R.id.teams_recyclerview);
        configureAdapter(teams_recyclerview);
    }

    public void configureAdapter(RecyclerView teams_recyclerview) {
        teams_recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Team team, int position) {
                initFormUpdateTeam(team, position);
            }
        });
    }

    private void initFormUpdateTeam(Team team, int position) {
        Intent initFormDataTeam = new Intent(TeamListActivity.this, DetailTeamActivity.class);
        initFormDataTeam.putExtra(TEAM_KEY, team);
        initFormDataTeam.putExtra(POSITION_KEY, position);
        startActivityForResult(initFormDataTeam, REQUEST_CODE_UPDATE_TEAM);
    }
}
