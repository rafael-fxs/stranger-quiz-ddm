package com.example.strangerquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.strangerquiz.ui.theme.StrangerQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrangerQuizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    StartScreen(onEnterClick = {})
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(onEnterClick: (User) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.padding(42.dp)) {
            var username by remember {
                mutableStateOf("")
            }
            AsyncImage(
                "https://1000logos.net/wp-content/uploads/2021/04/Stranger-Things-logo.png",
                contentDescription = "Logo Stranger Things",
                Modifier
                    .fillMaxWidth()
                    .height(140.dp),
            )
            TextField(
                value = username,
                onValueChange = {
                    username = it
                },
                Modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth(),
                label = {
                    Text("Your Name")
                },
            )
            Button(
                onClick = {
                    onEnterClick(User(username))
                },
                Modifier
                    .fillMaxWidth(),
            ) {
                Text(text = "Start")
            }
        }
    }

}

@Preview
@Composable
fun StartScreenPreview() {
    StrangerQuizTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            StartScreen(onEnterClick = {})
        }
    }
}