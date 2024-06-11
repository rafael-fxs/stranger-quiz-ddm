package com.example.strangerquiz.model.repository

import android.content.Context
import com.example.strangerquiz.model.data.LeaderboardEntity
import com.example.strangerquiz.model.data.LeaderboardDao
import com.example.strangerquiz.model.data.LeaderboardDatabase

object LeaderboardRepository {
    private lateinit var dao: LeaderboardDao
    fun setContext(context: Context) {
        LeaderboardDatabase.getInstance(context)?.apply {
            dao = leaderboardDao()
        }
    }

    fun add(lead: LeaderboardEntity) {
        dao.insert(lead)
    }

    fun update(lead: LeaderboardEntity) {
        dao.update(lead)
    }

    fun getTopScores(): List<LeaderboardEntity> {
        return dao.getTopScores()
    }

    fun getEntryByName(name: String): LeaderboardEntity? {
        return dao.getEntryByName(name)
    }

    fun clearAll() {
        dao.clearAll()
    }
}