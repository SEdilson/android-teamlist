package com.example.teamlist.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teamlist.R;
import com.example.teamlist.models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamListAdapter extends BaseAdapter {

    private final List<Team> teams = new ArrayList<>();
    private final Context context;

    public TeamListAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Team getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return teams.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View createdView = createView(viewGroup);
        Team retrievedTeam = teams.get(position);
        bindTeamWithCreatedView(createdView, retrievedTeam);
        return createdView;
    }

    private void bindTeamWithCreatedView(View view, Team team) {
        TextView name = view.findViewById(R.id.activity_team_list_name);
        name.setText(team.getName());
        TextView league = view.findViewById(R.id.activity_team_list_league);
        league.setText(team.getLeague());
    }

    private View createView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_team, viewGroup, false);
    }

    public void updateView(List<Team> allTeams) {
        teams.clear();
        this.teams.addAll(allTeams);
        notifyDataSetChanged();
    }

    public void remove(Team team) {
        teams.remove(team);
        notifyDataSetChanged();
    }

}
