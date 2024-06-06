package com.example.strangerquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.strangerquiz.ui.screens.QuestionsScreen
import com.example.strangerquiz.ui.screens.SignInScreen
import com.example.strangerquiz.ui.theme.StrangerQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrangerQuizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "questions/{user}") {
                        composable("questions/{user}") { entry ->
                            entry.arguments?.getString("user")?.let { user ->
                                QuestionsScreen(user = user)
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }

                        }
                        composable("signIn") {
                            SignInScreen(onSignInClick = { user ->
                                navController.navigate("questions/${user.name}")
                            })
                        }
                    }
                }
            }
        }
    }
}