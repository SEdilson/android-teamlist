package com.example.teamlist.asynctask;

import android.os.AsyncTask;

import com.example.teamlist.R;
import com.example.teamlist.database.dao.RoomTeamDAO;
import com.example.teamlist.models.Team;

import java.util.List;

import static com.example.teamlist.TeamsInfo.AMERICAN_LEAGUE;
import static com.example.teamlist.TeamsInfo.CENTRAL_DIVISION;
import static com.example.teamlist.TeamsInfo.EAST_DIVISION;
import static com.example.teamlist.TeamsInfo.NATIONAL_LEAGUE;
import static com.example.teamlist.TeamsInfo.WEST_DIVISION;

public class SearchTeamTask extends AsyncTask<Void, Void, List<Team>> {

    private RoomTeamDAO dao;
    private ConfigureAdapterListener listener;

    public SearchTeamTask(RoomTeamDAO dao, ConfigureAdapterListener listener) {
        this.dao = dao;
        this.listener = listener;
    }

    @Override
    protected List<Team> doInBackground(Void... voids) {
        return saveTeams();
    }

    public List<Team> saveTeams() {
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
        return dao.allTeams();
    }

    @Override
    protected void onPostExecute(List<Team> teams) {
        super.onPostExecute(teams);
        listener.configureAdapter();
    }

    public interface ConfigureAdapterListener {
        void configureAdapter();
    }
}
