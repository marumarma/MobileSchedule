package com.example.composeschedule.ui.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeschedule.R

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
            Image(painterResource(id = R.drawable.step1), contentDescription = null)
            Text(
                text = "Какое расписание вас интересует?", fontSize = 30.sp, modifier = Modifier
                    .padding(top = 10.dp, start = 35.dp)
            )

        }

    }
}