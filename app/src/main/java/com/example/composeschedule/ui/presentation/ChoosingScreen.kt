package com.example.composeschedule.ui.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.Screen

@Composable

fun ChoosingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .width(500.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(id = R.drawable.step1), contentDescription = null, modifier = Modifier.size(width = 350.dp, height = 50.dp))
            Text(
                text = "Какое расписание вас интересует?", fontSize = 30.sp, modifier = Modifier
                    .padding(top = 10.dp, start = 35.dp, bottom = 20.dp)
            )
            Image(painterResource(id = R.drawable.gr), contentDescription = null, modifier = Modifier.size(width= 340.dp, height = 120.dp).clickable(onClick = {navController.navigate(
                Screen.ListScreen.route)}))
            Image(painterResource(id = R.drawable.aud), contentDescription = null, modifier = Modifier.size(width= 340.dp, height = 120.dp).clickable(onClick = {navController.navigate(
                Screen.ListScreen.route)}))
            Image(painterResource(id = R.drawable.prep), contentDescription = null, modifier = Modifier.size(width= 340.dp, height = 120.dp).clickable(onClick = {navController.navigate(
                Screen.ListScreen.route)}))

            Text(text = "Есть ТГУ.Аккаунт?", fontSize = 18.sp, modifier = Modifier.padding(top = 260.dp).clickable(onClick = {navController.navigate(Screen.SignInScreen.route)}), textDecoration = TextDecoration.Underline, color = Color(0, 108, 190))

        }

    }
}