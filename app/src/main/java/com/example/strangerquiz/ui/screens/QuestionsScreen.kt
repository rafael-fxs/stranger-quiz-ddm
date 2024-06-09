package com.example.strangerquiz.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.strangerquiz.Constants
import com.example.strangerquiz.models.Question
import com.example.strangerquiz.ui.screens.ui.theme.StrangerQuizTheme
import java.math.BigDecimal
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsScreen(user: String) {
    val questions = Constants.getQuestion()
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.padding(42.dp)) {
            var username by remember {
                mutableStateOf("")
            }
            Text(text = "Question")
            AsyncImage(
                "https://1000logos.net/wp-content/uploads/2021/04/Stranger-Things-logo.png",
                contentDescription = "Logo Stranger Things",
                Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(Color.Gray),
            )
            LazyColumn {
                items(questions) { question ->
                    Column() {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Black),
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Text(text = "Enviar")
                        }
                    }
                }
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(text = "Enviar")
            }
        }
    }
}

@Preview
@Composable
fun QuestionsScreenPreview() {
    StrangerQuizTheme {
        Surface(
            Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            QuestionsScreen("alex")
        }
    }
}