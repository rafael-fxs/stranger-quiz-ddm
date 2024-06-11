package com.example.strangerquiz.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.strangerquiz.viewmodel.LeaderboardViewModel

@Composable
fun LeaderboardScreen(viewModel: LeaderboardViewModel, navController: NavHostController) {
    val leaderboardEntries by viewModel.leaderboardEntries.collectAsState(initial = emptyList())

    BackHandler {
        navController.navigate("signIn") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Leaderboard", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Limpar histórico",
                color = Color.Red,
                style = MaterialTheme.typography.titleSmall.copy(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {
                    viewModel.clearLeaderboard()
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(leaderboardEntries) { entry ->
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text(entry.name, modifier = Modifier.weight(1f))
                    Text(entry.score.toInt().toString())
                }
            }
        }
    }
}