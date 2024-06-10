package com.example.strangerquiz.model.repository

import android.content.Context
import com.example.strangerquiz.model.LeaderboardEntry
import com.example.strangerquiz.model.data.LeaderboardDao
import com.example.strangerquiz.model.data.LeaderboardDatabase

object LeaderboardRepository {
    private lateinit var dao: LeaderboardDao
    fun setContext(context: Context) {
        LeaderboardDatabase.getInstance(context)?.apply {
            dao = leaderboardDao()
        }
    }

    fun add(lead: LeaderboardEntry) {
        dao.insert(lead)
    }

    fun update(lead: LeaderboardEntry) {
        dao.update(lead)
    }

    fun getTopScores(): List<LeaderboardEntry> {
        return dao.getTopScores()
    }

    fun getEntryByName(name: String): LeaderboardEntry? {
        return dao.getEntryByName(name)
    }
}