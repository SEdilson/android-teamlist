package com.example.teamlist.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamlist.R;
import com.example.teamlist.database.TeamListDatabase;
import com.example.teamlist.database.dao.RoomTeamDAO;
import com.example.teamlist.models.Team;
import com.example.teamlist.ui.recycler.adapter.TeamListAdapter;
import com.example.teamlist.ui.recycler.adapter.listener.OnItemClickListener;

import java.util.List;

import static com.example.teamlist.TeamsInfo.AMERICAN_LEAGUE;
import static com.example.teamlist.TeamsInfo.CENTRAL_DIVISION;
import static com.example.teamlist.TeamsInfo.EAST_DIVISION;
import static com.example.teamlist.TeamsInfo.NATIONAL_LEAGUE;
import static com.example.teamlist.TeamsInfo.WEST_DIVISION;
import static com.example.teamlist.ui.activity.TeamKeys.INVALID_POSITION;
import static com.example.teamlist.ui.activity.TeamKeys.POSITION_KEY;
import static com.example.teamlist.ui.activity.TeamKeys.REQUEST_CODE_UPDATE_TEAM;
import static com.example.teamlist.ui.activity.TeamKeys.TEAM_KEY;

public class TeamListActivity extends AppCompatActivity {

    private static final String TEAM_LIST_TITLE_APPBAR = "Team List";
    private RoomTeamDAO dao;
    private TeamListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        setTitle(TEAM_LIST_TITLE_APPBAR);
        configureTeamList();
    }

    private List<Team> getAllTeams() {
        saveTeams();
        return dao.allTeams();
    }

    public void saveTeams() {
        dao.save(new Team("Los Angeles Dodgers", NATIONAL_LEAGUE,
                WEST_DIVISION, 6, R.drawable.la_dodgers_logo));
        dao.save(new Team("Arizona Diamondbacks", NATIONAL_LEAGUE, WEST_DIVISION,
                1, R.drawable.arizona_diamondbacks_logo));
        dao.save(new Team("Atlanta Braves", NATIONAL_LEAGUE, EAST_DIVISION,
                3, R.drawable.atlanta_braves_logo));
        dao.save(new Team("Baltimore Orioles", AMERICAN_LEAGUE, EAST_DIVISION,
                3, R.drawable.baltimore_orioles_logo));
        dao.save(new Team("Boston Red Sox", AMERICAN_LEAGUE, EAST_DIVISION,
                9, R.drawable.boston_red_sox_logo));
        dao.save(new Team("Chicago Cubs", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                3, R.drawable.chicago_cubs_logo));
        dao.save(new Team("Chicago White Sox", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                3, R.drawable.chicago_white_sox_logo));
        dao.save(new Team("Cincinnati Reds", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                5, R.drawable.cincinnati_reds_logo));
        dao.save(new Team("Cleveland Indians", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                2, R.drawable.cleveland_indians_logo));
        dao.save(new Team("Colorado Rockies", NATIONAL_LEAGUE, WEST_DIVISION,
                0, R.drawable.colorado_rockies_logo));
        dao.save(new Team("Detroit Tigers", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                4, R.drawable.detroit_tigers_logo));
        dao.save(new Team("Houston Astros", AMERICAN_LEAGUE, WEST_DIVISION,
                1, R.drawable.houston_astros_logo));
        dao.save(new Team("Kansas City Royals", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                2, R.drawable.kc_royals_logo));
        dao.save(new Team("Los Angeles Angels", AMERICAN_LEAGUE, WEST_DIVISION,
                1, R.drawable.la_angels_logo));
        dao.save(new Team("Miami Marlins", NATIONAL_LEAGUE, EAST_DIVISION,
                2, R.drawable.miami_marlins_logo));
        dao.save(new Team("Milwaukee Brewers", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                0, R.drawable.milwaukee_brewers_logo));
        dao.save(new Team("Minnesota Twins", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                3, R.drawable.min_twins_logo));
        dao.save(new Team("New York Mets", NATIONAL_LEAGUE, EAST_DIVISION,
                2, R.drawable.ny_mets_logo));
        dao.save(new Team("New York Yankees", AMERICAN_LEAGUE, EAST_DIVISION,
                27, R.drawable.ny_yankees_logo));
        dao.save(new Team("Oakland Athletics", AMERICAN_LEAGUE, WEST_DIVISION,
                9, R.drawable.oakland_athletics_logo));
        dao.save(new Team("Philadelphia Phillies", NATIONAL_LEAGUE, EAST_DIVISION,
                2, R.drawable.phi_phillies_logo));
        dao.save(new Team("Pittsburgh Pirates", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                5, R.drawable.pit_pirates_logo));
        dao.save(new Team("San Diego Padres", NATIONAL_LEAGUE, WEST_DIVISION,
                0, R.drawable.sd_padres_logo));
        dao.save(new Team("Seattle Mariners", AMERICAN_LEAGUE, WEST_DIVISION,
                0, R.drawable.seattle_mariners_logo));
        dao.save(new Team("San Francisco Giants", NATIONAL_LEAGUE, WEST_DIVISION,
                8, R.drawable.sf_giants_logo));
        dao.save(new Team("Saint Louis Cardinals", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                11, R.drawable.stl_cardinals_logo));
        dao.save(new Team("Tampa Bay Rays", AMERICAN_LEAGUE, EAST_DIVISION,
                0, R.drawable.tb_rays_logo));
        dao.save(new Team("Texas Rangers", AMERICAN_LEAGUE, WEST_DIVISION,
                2, R.drawable.texas_rangers_logo));
        dao.save(new Team("Toronto Blue Jays", AMERICAN_LEAGUE, EAST_DIVISION,
                2, R.drawable.toronto_blue_jays_logo));
        dao.save(new Team("Washington Nationals", NATIONAL_LEAGUE, EAST_DIVISION,
                1, R.drawable.washington_nationals_logo));
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
        dao.change(team);
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
        dao = TeamListDatabase.getInstance(this).getRoomTeamDAO();
        configureAdapter(teams_recyclerview);
    }

    public void configureAdapter(RecyclerView teams_recyclerview) {
        adapter = new TeamListAdapter(this, getAllTeams());
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
