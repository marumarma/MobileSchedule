package com.example.composeschedule.navigation


sealed class Screen(val route: String) {
    object SignInScreen : Screen("sign_in_screen")
    object MainScreen : Screen("main_screen")

}
