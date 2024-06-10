package com.example.strangerquiz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.strangerquiz.viewmodel.LeaderboardViewModel

@Composable
fun LeaderboardScreen(viewModel: LeaderboardViewModel) {
    val leaderboardEntries by viewModel.leaderboardEntries.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Leaderboard", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 16.dp))
        LazyColumn {
            items(leaderboardEntries) { entry ->
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text(entry.name, modifier = Modifier.weight(1f))
                    Text(entry.score.toString())
                }
            }
        }
    }
}