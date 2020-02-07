package com.example.teamlist.ui.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamlist.R;
import com.example.teamlist.models.Team;
import com.example.teamlist.ui.recycler.adapter.listener.OnItemClickListener;
import com.example.teamlist.utils.TitlesUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// TODO Implement long click to delete a item

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamListViewHolder> {

    private List<Team> teams;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public TeamListAdapter(Context context, List<Team> teams) {
        this.teams = teams;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamListAdapter.TeamListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_team, viewGroup, false);
        return new TeamListViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamListAdapter.TeamListViewHolder holder, int position) {
        Team retrievedTeam = teams.get(position);
        holder.bindFields(retrievedTeam);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void change(int posicao, Team team) {
        teams.set(posicao, team);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class TeamListViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;
        private final TextView league;
        private final TextView division;
        private final TextView numberOfTitles;
        private Team team;

        public TeamListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.activity_item_team_image);
            name = itemView.findViewById(R.id.activity_item_team_name);
            league = itemView.findViewById(R.id.activity_item_team_league);
            division = itemView.findViewById(R.id.activity_item_team_division);
            numberOfTitles = itemView.findViewById(R.id.activity_item_team_number_of_titles);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(team, getAdapterPosition());
                }
            });
        }

        public void bindFields(Team team) {
            this.team = team;
            insertDataOnFields(team);
        }

        private void insertDataOnFields(Team team) {
            Picasso.with(context).load(team.getImage()).into(image);
            name.setText(team.getName());
            league.setText(team.getLeague());
            division.setText(team.getDivision());
            numberOfTitles.setText(TitlesUtil.formatTitles(team.getNumberOfTitles()));
        }
    }
}
