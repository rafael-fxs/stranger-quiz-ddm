package com.example.strangerquiz.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strangerquiz.model.LeaderboardEntry
import com.example.strangerquiz.model.repository.LeaderboardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LeaderboardViewModel : ViewModel() {
    val leaderboardEntries = MutableStateFlow<List<LeaderboardEntry>>(emptyList())

    init {
        viewModelScope.launch {
            leaderboardEntries.value = LeaderboardRepository.getTopScores()
        }
    }

    fun updateLeaderboard(user: String, points: Double) {
        viewModelScope.launch {
            val existingEntry = LeaderboardRepository.getEntryByName(user)
            if (existingEntry == null) {
                LeaderboardRepository.add(LeaderboardEntry(name = user, score = points))
            } else if (existingEntry.score < points) {
                LeaderboardRepository.update(existingEntry.copy(score = points))
            }
            leaderboardEntries.value = LeaderboardRepository.getTopScores()
        }
    }

    fun clearLeaderboard() {
        viewModelScope.launch {
            LeaderboardRepository.clearAll()
            leaderboardEntries.value = emptyList()
        }
    }
}