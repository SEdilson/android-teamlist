package com.example.teamlist;

import android.app.Application;

import com.example.teamlist.dao.TeamDAO;
import com.example.teamlist.models.Team;

import static com.example.teamlist.TeamsInfo.AMERICAN_LEAGUE;
import static com.example.teamlist.TeamsInfo.CENTRAL_DIVISION;
import static com.example.teamlist.TeamsInfo.EAST_DIVISION;
import static com.example.teamlist.TeamsInfo.NATIONAL_LEAGUE;
import static com.example.teamlist.TeamsInfo.WEST_DIVISION;

public class TeamListApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        listTeams();
    }

    private void listTeams() {
        TeamDAO dao = new TeamDAO();
        dao.saveTeam(new Team("Los Angeles Dodgers", NATIONAL_LEAGUE,
                WEST_DIVISION, 6, "la_dodgers_logo"));
        dao.saveTeam(new Team("Arizona Diamondbacks", NATIONAL_LEAGUE, WEST_DIVISION,
                1, "arizona_diamondbacks_logo"));
        dao.saveTeam(new Team("Atlanta Braves", NATIONAL_LEAGUE, EAST_DIVISION,
                3, "atlanta_braves_logo"));
        dao.saveTeam(new Team("Baltimore Orioles", AMERICAN_LEAGUE, EAST_DIVISION,
                3, "baltimore_orioles_logo"));
        dao.saveTeam(new Team("Boston Red Sox", AMERICAN_LEAGUE, EAST_DIVISION,
                9, "boston_red_sox_logo"));
        dao.saveTeam(new Team("Chicago Cubs", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                3, "chicago_cubs_logo"));
        dao.saveTeam(new Team("Chicago White Sox", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                3, "chicago_white_sox_logo"));
        dao.saveTeam(new Team("Cincinnati Reds", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                5, "cincinnati_reds_logo"));
        dao.saveTeam(new Team("Cleveland Indians", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                2, "cleveland_indians_logo"));
        dao.saveTeam(new Team("Colorado Rockies", NATIONAL_LEAGUE, WEST_DIVISION,
                0, "colorado_rockies_logo"));
        dao.saveTeam(new Team("Detroit Tigers", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                4, "detroit_tigers_logo"));
        dao.saveTeam(new Team("Houston Astros", AMERICAN_LEAGUE, WEST_DIVISION,
                1, "houston_astros_logo"));
        dao.saveTeam(new Team("Kansas City Royals", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                2, "kc_royals_logo"));
        dao.saveTeam(new Team("Los Angeles Angels", AMERICAN_LEAGUE, WEST_DIVISION,
                1, "la_angels_logo"));
        dao.saveTeam(new Team("Miami Marlins", NATIONAL_LEAGUE, EAST_DIVISION,
                2, "miami_marlins_logo"));
        dao.saveTeam(new Team("Milwaukee Brewers", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                0, "milwaukee_brewers_logo"));
        dao.saveTeam(new Team("Minnesota Twins", AMERICAN_LEAGUE, CENTRAL_DIVISION,
                3, "min_twins_logo"));
        dao.saveTeam(new Team("New York Mets", NATIONAL_LEAGUE, EAST_DIVISION,
                2, "ny_mets_logo"));
        dao.saveTeam(new Team("New York Yankees", AMERICAN_LEAGUE, EAST_DIVISION,
                27, "ny_yankees_logo"));
        dao.saveTeam(new Team("Oakland Athletics", AMERICAN_LEAGUE, WEST_DIVISION,
                9, "oakland_athletics_logo"));
        dao.saveTeam(new Team("Philadelphia Phillies", NATIONAL_LEAGUE, EAST_DIVISION,
                2, "phi_phillies_logo"));
        dao.saveTeam(new Team("Pittsburgh Pirates", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                5, "pit_pirates_logo"));
        dao.saveTeam(new Team("San Diego Padres", NATIONAL_LEAGUE, WEST_DIVISION,
                0, "sd_padres_logo"));
        dao.saveTeam(new Team("Seattle Mariners", AMERICAN_LEAGUE, WEST_DIVISION,
                0, "seattle_mariners_logo"));
        dao.saveTeam(new Team("San Francisco Giants", NATIONAL_LEAGUE, WEST_DIVISION,
                8, "sf_giants_logo"));
        dao.saveTeam(new Team("Saint Louis Cardinals", NATIONAL_LEAGUE, CENTRAL_DIVISION,
                11, "stl_cardinals_logo"));
        dao.saveTeam(new Team("Tampa Bay Rays", AMERICAN_LEAGUE, EAST_DIVISION,
                0, "tb_rays_logo"));
        dao.saveTeam(new Team("Texas Rangers", AMERICAN_LEAGUE, WEST_DIVISION,
                2, "texas_rangers_logo"));
        dao.saveTeam(new Team("Toronto Blue Jays", AMERICAN_LEAGUE, EAST_DIVISION,
                2, "toronto_blue_jays_logo"));
        dao.saveTeam(new Team("Washington Nationals", NATIONAL_LEAGUE, EAST_DIVISION,
                1, "washington_nationals_logo"));
    }
}
