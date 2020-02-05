package com.example.teamlist.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.teamlist.models.Team;

import java.util.List;

@Dao
public interface RoomTeamDAO {

    @Insert
    void save(Team team);

    @Query("SELECT * FROM team")
    List<Team> allTeams();

    @Delete
    void remove(Team team);

    @Update
    void change(Team team);
}
