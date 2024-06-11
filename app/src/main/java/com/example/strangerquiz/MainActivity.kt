package com.example.strangerquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.strangerquiz.model.repository.LeaderboardRepository
import com.example.strangerquiz.ui.screens.LeaderboardScreen
import com.example.strangerquiz.ui.screens.QuestionsScreen
import com.example.strangerquiz.ui.screens.SignInScreen
import com.example.strangerquiz.ui.theme.StrangerQuizTheme
import com.example.strangerquiz.viewmodel.LeaderboardViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeaderboardRepository.setContext(this)
        setContent {
            StrangerQuizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val leaderboardViewModel: LeaderboardViewModel = viewModel()
                    NavHost(navController = navController, startDestination = "signIn") {
                        composable("questions/{user}") { entry ->
                            entry.arguments?.getString("user")?.let { user ->
                                QuestionsScreen(user = user, viewModel = leaderboardViewModel, navController = navController)
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }

                        }
                        composable("signIn") {
                            SignInScreen(onSignInClick = { user ->
                                navController.navigate("questions/${user.name}")
                            }, navController)
                        }
                        composable("leaderboard") {
                            LeaderboardScreen(viewModel = leaderboardViewModel, navController = navController)
                        }
                    }
                }
            }
        }
    }
}