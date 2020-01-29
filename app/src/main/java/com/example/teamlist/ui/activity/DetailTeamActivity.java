package com.example.teamlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teamlist.R;
import com.example.teamlist.dao.TeamDAO;
import com.example.teamlist.models.Team;
import com.example.teamlist.utils.ImageUtil;

import static com.example.teamlist.ui.activity.TeamKeys.TEAM_KEY;

public class DetailTeamActivity extends AppCompatActivity {

    private static final String UPDATE_TEAM_TITLE_APPBAR = "Update Team";
    private EditText nameField;
    private EditText leagueField;
    private EditText divisionField;
    private EditText numberOfTitlesField;
    TeamDAO dao = new TeamDAO();
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        setTitle(UPDATE_TEAM_TITLE_APPBAR);

        initFields();
        retrieveTeam();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_team_menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_add_team_menu_save) {
            endForm();
        }
        return super.onOptionsItemSelected(item);
    }

    private void retrieveTeam() {
        Intent teamData = getIntent();
        if(teamData.hasExtra(TEAM_KEY)) {
            team = (Team) teamData.getSerializableExtra(TEAM_KEY);
            nameField.setText(team.getName());
            leagueField.setText(team.getLeague());
            divisionField.setText(team.getDivision());
            numberOfTitlesField.setText(String.valueOf(team.getNumberOfTitles()));
        }
    }

    private void endForm() {
        fillTeam();
        if(team.hasValidId()) {
            dao.updateTeam(team);
        }
        finish();
    }

    private void fillTeam() {
        String name = nameField.getText().toString();
        String league = leagueField.getText().toString();
        String division = divisionField.getText().toString();
        int numberOfTitles = Integer.parseInt(numberOfTitlesField.getText().toString());

        team.setName(name);
        team.setLeague(league);
        team.setDivision(division);
        team.setNumberOfTitles(numberOfTitles);
    }

    @NonNull
    public void initFields() {
        nameField = findViewById(R.id.activity_detail_team_name);
        leagueField = findViewById(R.id.activity_detail_team_league);
        divisionField = findViewById(R.id.activity_detail_team_division);
        numberOfTitlesField = findViewById(R.id.activity_detail_team_number_of_titles);
    }
}
