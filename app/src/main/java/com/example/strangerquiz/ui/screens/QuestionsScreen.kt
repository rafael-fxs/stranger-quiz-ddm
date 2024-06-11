package com.example.strangerquiz.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.strangerquiz.Constants
import com.example.strangerquiz.ui.screens.ui.theme.StrangerQuizTheme
import com.example.strangerquiz.viewmodel.LeaderboardViewModel

@Composable
fun QuestionsScreen(
    user: String,
    viewModel: LeaderboardViewModel,
    navController: NavHostController
) {
    val questions = remember { Constants.getQuestion().shuffled() }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf(-1) }
    var correctAnswers by remember { mutableStateOf(0) }
    var showNextButton by remember { mutableStateOf(false) }
    val currentQuestion = questions[currentQuestionIndex]
    val shuffledOptions = remember(currentQuestion) { currentQuestion.options.shuffled() }

    val totalQuestions = questions.size

    var startTime by remember { mutableStateOf(System.currentTimeMillis()) }

    val progressColor = remember {
        val startColor = Color.Red // Cor inicial da barra de progresso
        val endColor = Color.Green // Cor final da barra de progresso
        val progressFraction = (currentQuestionIndex + 1).toFloat() / totalQuestions.toFloat()
        lerp(startColor, endColor, progressFraction)
    }

    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(currentQuestionIndex) {
        animatedProgress.animateTo(
            targetValue = (currentQuestionIndex + 1).toFloat() / totalQuestions.toFloat(),
            animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Question",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = currentQuestion.description,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        AsyncImage(
            "https://1000logos.net/wp-content/uploads/2021/04/Stranger-Things-logo.png",
            contentDescription = "Logo Stranger Things",
            Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(Color.Gray),
        )
        Text(
            text = "${currentQuestionIndex + 1}/${questions.size}",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )
        LinearProgressIndicator(
            progress = (currentQuestionIndex + 1).toFloat() / questions.size,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            color = Color.Red
        )
        LazyColumn {
            items(shuffledOptions) { option ->
                val optionIndex = shuffledOptions.indexOf(option)
                val isSelected = selectedOptionIndex == optionIndex
                Button(
                    onClick = { if (!showNextButton) selectedOptionIndex = optionIndex },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (showNextButton && option.correct) Color.Green
                        else if (isSelected) Color.Gray else Color.Transparent,
                        contentColor = if (showNextButton && option.correct) Color.Black else if (selectedOptionIndex == optionIndex) Color.White else Color.Gray
                    ),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(
                        if (isSelected) 2.dp else 1.dp,
                        if (showNextButton && option.correct) Color.Green else Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                ) {
                    Text(text = option.answer)
                }
            }
        }

        Button(
            onClick = {
                if (!showNextButton) {
                    val endTime = System.currentTimeMillis()
                    val responseTime = (endTime - startTime) / 1000.0 // tempo em segundos
                    val points =
                        if (shuffledOptions[selectedOptionIndex].correct) 100.0 / responseTime else 0.0


                    viewModel.updateLeaderboard(user, points)

                    showNextButton = true
                    if (shuffledOptions[selectedOptionIndex].correct) {
                        correctAnswers++
                    }
                } else {
                    if (currentQuestionIndex + 1 == totalQuestions) {
                        navController.navigate("leaderboard")
                    } else {
                        showNextButton = false
                        selectedOptionIndex = -1
                        currentQuestionIndex++
                        startTime = System.currentTimeMillis()
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            enabled = selectedOptionIndex != -1
        ) {
            Text(text = if (showNextButton) "Next question" else "Send")
        }
    }
}

@Preview
@Composable
fun QuestionsScreenPreview() {
    val leaderboardViewModel: LeaderboardViewModel = viewModel()
    val navController = rememberNavController()
    StrangerQuizTheme {
        Surface(
            Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            QuestionsScreen("alex", leaderboardViewModel, navController)
        }
    }
}