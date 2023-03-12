package com.example.composeschedule.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeschedule.ui.presentation.*

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
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
        composable(route = Screen.GroupsListScreen.route) {
            GroupsListScreen(navController = navController)
        }
        composable(route = Screen.AudsListScreen.route) {
            AudsListScreen(navController = navController)
        }
        composable(route = Screen.TeachersListScreen.route) {
            TeachersListScreen(navController = navController)
        }
        composable(route = Screen.ScheduleScreen.route, arguments = listOf(
            navArgument(DATA) {
                type = NavType.StringType
            },
                    navArgument(TYPE) {
                type = NavType.StringType
            },
            navArgument(NAME) {
                type = NavType.StringType
            }
        )) {
            it.arguments?.let { it1 -> ScheduleScreen(navController, it1) }
        }
    }
}