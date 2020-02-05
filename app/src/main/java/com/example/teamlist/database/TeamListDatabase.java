package com.example.teamlist.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.teamlist.database.dao.RoomTeamDAO;
import com.example.teamlist.models.Team;

import static com.example.teamlist.database.TeamListMigrations.MIGRATIONS;

@Database(entities = {Team.class}, version = 6, exportSchema = false)
public abstract class TeamListDatabase extends RoomDatabase {

    private static final String TEAM_LIST_DB = "teamlist.db";

    public abstract RoomTeamDAO getRoomTeamDAO();

    public static TeamListDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, TeamListDatabase.class, TEAM_LIST_DB)
                .allowMainThreadQueries()
                .addMigrations(MIGRATIONS)
                .build();
    }
}
