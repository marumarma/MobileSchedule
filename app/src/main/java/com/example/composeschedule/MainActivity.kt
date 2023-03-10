package com.example.composeschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.composeschedule.navigation.Navigation
import com.example.composeschedule.ui.presentation.SignInScreen
import com.example.composeschedule.ui.theme.ComposeScheduleTheme

//ddididdi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScheduleTheme{
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}
