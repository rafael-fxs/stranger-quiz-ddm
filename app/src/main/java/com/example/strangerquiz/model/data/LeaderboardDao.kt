package com.example.strangerquiz.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LeaderboardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entry: LeaderboardEntity): Long

    @Update
    fun update(entry: LeaderboardEntity)

    @Query("SELECT * FROM leaderboard ORDER BY score DESC LIMIT 10")
    fun getTopScores(): List<LeaderboardEntity>

    @Query("SELECT * FROM leaderboard WHERE name = :name LIMIT 1")
    fun getEntryByName(name: String): LeaderboardEntity?

    @Query("DELETE FROM leaderboard")
    fun clearAll()
}