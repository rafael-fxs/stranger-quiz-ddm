package com.example.strangerquiz.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leaderboard")
data class LeaderboardEntry (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val score: Double
)