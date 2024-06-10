package com.example.strangerquiz.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.strangerquiz.model.LeaderboardEntry

@Dao
interface LeaderboardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entry: LeaderboardEntry): Long

    @Update
    fun update(entry: LeaderboardEntry)

    @Query("SELECT * FROM leaderboard ORDER BY score DESC LIMIT 10")
    fun getTopScores(): List<LeaderboardEntry>

    @Query("SELECT * FROM leaderboard WHERE name = :name LIMIT 1")
    fun getEntryByName(name: String): LeaderboardEntry?
}