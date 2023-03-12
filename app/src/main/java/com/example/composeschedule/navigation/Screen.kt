package com.example.composeschedule.navigation

const val STUDENT_DATA = "student_data"
const val TEACHER_DATA = "teacher_data"
const val SCHEDULE_TYPE = "schedule_type"
const val DATA_ID = "data_id"
sealed class Screen(val route: String) {
    object SignInScreen : Screen("sign_in_screen")
    object MainScreen : Screen("main_screen/{$SCHEDULE_TYPE}/{$DATA_ID}"){
        fun passScheduleInfo(
            type: String,
            dataId: String,
            //data: String? = null
        ): String = "main_screen/$type/$dataId"
    }
    object RegisterScreen : Screen("register_screen")
    object ChoosingScreen : Screen("choosing_screen/{$STUDENT_DATA}/{$TEACHER_DATA}"){
        fun passScheduleInfo(
            studentData: String,
            teacherData: String
        ): String = "choice_screen/$studentData/$teacherData"
    }
    object GroupsListScreen : Screen("groupslist_screen")
    object TeachersListScreen : Screen("teacherslist_screen")
    object AudsListScreen : Screen("audslist_screen")
    object ScheduleScreen : Screen("schedule_screen")

}
