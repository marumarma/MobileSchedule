package com.example.composeschedule.ui.presentation

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.DATA
import com.example.composeschedule.navigation.NAME
import com.example.composeschedule.navigation.Screen
import com.example.composeschedule.navigation.TYPE
import com.mrerror.singleRowCalendar.SingleRowCalendar
import java.util.*

@Composable

fun ScheduleScreen(navController: NavController, id : Bundle) {
    var day by remember { mutableStateOf(Date()) }
    val viewModel : ScheduleViewModel = viewModel()
    viewModel.getClass(id.getString(DATA).toString(), id.getString(TYPE).toString(), id.getString(NAME).toString() ,day)
    Column(Modifier.fillMaxWidth()) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp, end = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "         ")
                when(viewModel.schedule_type){
                    "GROUP" -> {
                        headgr(viewModel())
                    }
                    "TEACHER" -> {
                        headte(viewModel())
                    }
                    "CLASSROOM" -> {
                        headcl(viewModel())
                    }

                }

                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    tint = Color(0, 108, 190),
                    contentDescription = "", modifier = Modifier
                        .size(35.dp)
                        .clickable(onClick = {
                            navController.navigate(
                                Screen.MainScreen.route
                            )
                        })
                )
            }

            SingleRowCalendar(
                onSelectedDayChange = {
                    day = it
                    viewModel.getClass(data = it)
                }, selectedDayBackgroundColor = Color(0, 108, 190),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(245, 245, 245))
            ) {
                Column(
                    modifier = Modifier
                        .background(Color(245, 245, 245))
                        .fillMaxWidth()
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    val state = viewModel.clas.collectAsState().value
                    if(state.size > 0){
                        for(i in 0..state.size-1){
                            getCard(viewModel(), i)
                        }
                    }

                }

            }


        }

    }

}
@Composable
fun headgr(viewModel: ScheduleViewModel){

    Text(
        text = "Группа" + " " + viewModel.schedule_name,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 10.dp)
    )
}
@Composable
fun headte(viewModel: ScheduleViewModel){

    Text(
        text = viewModel.schedule_name,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 10.dp)
    )
}
@Composable
fun headcl(viewModel: ScheduleViewModel){

    Text(
        text = "Аудитория" + " " + viewModel.schedule_name,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Composable
fun getCard(viewModel: ScheduleViewModel, i: Int){

    val state = viewModel.clas.collectAsState().value
    var subjectName = if(state.size > 0) state[i].subject.name else " "
    var teacherName = if(state.size > 0) state[i].teacher.name else " "
    var audName = if(state.size > 0) state[i].classroom.name else " "
    var startTime = if(state.size > 0) state[i].timeslot.start_time else "   "
     startTime = startTime.substring(0, startTime.length - 3)
    var number = if(state.size > 0) state[i].timeslot.id else " "
    var endTime = if(state.size > 0) state[i].timeslot.end_time else "   "
    endTime = endTime.substring(0, endTime.length - 3)
    var buildName = if(state.size > 0) state[i].classroom.building.address else " "
    var groupName = ""
    var lesNumber = ""
    var groups = if(state.size > 0){
        for (j in 0..state[i].groups.size-1){
            groupName += state[i].groups[j].name + " "
        }
    }else null

    if (number == 1 || number == 8 || number == 15 || number == 22 || number == 29 || number == 36){
        lesNumber = "1-я пара"
    }
    else if(number == 2 || number == 9 || number == 16 || number == 23 || number == 30 || number == 37) {
        lesNumber = "2-я пара"
    }
    else if (number == 3 || number == 10 || number == 17 || number == 24 || number == 31 || number == 38){
        lesNumber = "3-я пара"
    }
    else if (number == 4 || number == 11 || number == 18 || number == 25 || number == 32 || number == 39){
        lesNumber = "4-я пара"
    }
    else if (number == 5 || number == 12 || number == 19 || number == 26 || number == 33 || number == 40){
        lesNumber = "5-я пара"
    }
    else if (number == 6 || number == 13 || number == 20 || number == 27 || number == 34 || number == 41){
        lesNumber = "6-я пара"
    }
    else if (number == 7 || number == 14 || number == 21 || number == 28 || number == 35 || number == 42){
        lesNumber = "7-я пара"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(17.dp),
        elevation = 5.dp,
        border = BorderStroke(3.dp, Color(242, 203, 0)),
        content = {
            //полная карточка
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                //Препод и вид пары
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(modifier = Modifier.width(255.dp),
                        text = subjectName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color(242, 203, 0)
                    ) {
                        Text(
                            text = "Семинар",
                            color = Color.White,
                            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 1.dp, bottom = 1.dp)
                        )
                    }
                }
                //Инфо
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                ) {
                    Text(text = teacherName)
                    Text(text = audName + ", " + buildName)
                    Text(text = "Группа " + groupName)

                }
                //Время и номер
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = startTime + " - " + endTime, color = Color(242, 203, 0), fontSize = 20.sp)
                    Text(text = lesNumber)

                }

            }
        })
}