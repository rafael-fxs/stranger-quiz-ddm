package com.example.strangerquiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.strangerquiz.R
import com.example.strangerquiz.model.User
import com.example.strangerquiz.ui.screens.ui.theme.StrangerQuizTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(onSignInClick: (User) -> Unit, navController: NavHostController) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.padding(42.dp)) {
            var username by remember {
                mutableStateOf("")
            }
            Image(
                painter = painterResource(id = R.drawable.logo),
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
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Red,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Red,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Red
                )
            )
            Button(
                onClick = {
                    onSignInClick(User(username))
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Leaderboard",
                color = Color.Red,
                style = MaterialTheme.typography.titleSmall.copy(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .clickable {
                        navController.navigate("leaderboard")
                    }
                    .align(Alignment.CenterHorizontally),
            )
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    val navController = rememberNavController()
    StrangerQuizTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            SignInScreen(onSignInClick = {}, navController)
        }
    }
}