package com.example.teamlist.ui.activity;

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

import static com.example.teamlist.ui.activity.TeamKeys.POSITION_KEY;
import static com.example.teamlist.ui.activity.TeamKeys.REQUEST_CODE_UPDATE_TEAM;
import static com.example.teamlist.ui.activity.TeamKeys.RESULT_CODE_UPDATE_TEAM;
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

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.activity_team_list_menu, menu);
//    }

//    @Override
//    public boolean onContextItemSelected(@NonNull final MenuItem item) {
//        int itemId = item.getItemId();
//        if(itemId == R.id.activity_team_list_menu_remove) {
//            adapter.setOnLongClickListener(new OnLongClickListener() {
//                @Override
//                public void onLongClick(Team team, int position) {
//                    teamListView.confirmRemove(item);
//                }
//            });
//        }
//        return super.onContextItemSelected(item);
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_UPDATE_TEAM &&
                resultCode == RESULT_CODE_UPDATE_TEAM &&
                data.hasExtra(POSITION_KEY)) {
            Team retrievedTeam = (Team) data.getSerializableExtra(TEAM_KEY);
            int positionReturned = data.getIntExtra(POSITION_KEY, -1);
            dao.change(positionReturned, retrievedTeam);
            adapter.change(positionReturned, retrievedTeam);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void configureTeamList() {
        RecyclerView teams_recyclerview = findViewById(R.id.teams_recyclerview);
        configureAdapter(teams, teams_recyclerview);
    }

    public void configureAdapter(List<Team> teams, RecyclerView teams_recyclerview) {
        adapter = new TeamListAdapter(this, teams);
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
        startActivityForResult(initFormDataTeam, 1);
    }
}
