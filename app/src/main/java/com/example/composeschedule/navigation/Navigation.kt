package com.example.composeschedule.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeschedule.ui.presentation.*

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.ScheduleScreen.route) {
        composable(route = Screen.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.ChoosingScreen.route) {
            ChoosingScreen(navController = navController)
        }
        composable(route = Screen.ListScreen.route){
            ListScreen(navController = navController)
        }
        composable(route = Screen.ScheduleScreen.route){
            ScheduleScreen(navController = navController)
        }
    }
}