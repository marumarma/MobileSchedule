package com.example.composeschedule.navigation

const val DATA = "data"
const val TYPE = "type"
const val NAME = "name"
sealed class Screen(val route: String) {
    object SignInScreen : Screen("sign_in_screen")
    object MainScreen : Screen("main_screen")
    object RegisterScreen : Screen("register_screen")
    object ChoosingScreen : Screen("choosing_screen")
    object GroupsListScreen : Screen("groupslist_screen")
    object TeachersListScreen : Screen("teacherslist_screen")
    object AudsListScreen : Screen("audslist_screen")
    object ScheduleScreen : Screen("schedule_screen/{$DATA}/{$TYPE}/{$NAME}"){
        fun passScheduleInfo(
            data : String,
            type: String,
            name : String
        ): String = "schedule_screen/$data/$type/$name"
    }

}
