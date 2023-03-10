package com.example.composeschedule.ui.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.Screen
import com.mrerror.singleRowCalendar.SingleRowCalendar
import java.util.*

@Composable

fun ScheduleScreen(navController: NavController) {
    var day by remember { mutableStateOf(Date()) }
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
                Text(
                    text = "Группа 972103",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 10.dp)
                )
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
                                        text = "Иностраный язык",
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
                                    Text(text = "Шилова Татьяна Валерьевна")
                                    Text(text = "Учебная аудитория 214, 2-ой корпус")
                                    Text(text = "Группа 972103(2)")

                                }
                                //Время и номер
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "8:45 - 10:20", color = Color(242, 203, 0), fontSize = 20.sp)
                                    Text(text = "1-я пара")

                                }

                            }
                        })

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        shape = RoundedCornerShape(17.dp),
                        elevation = 5.dp,
                        border = BorderStroke(3.dp, Color(226, 62, 52)),
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
                                        text = "Разработка и анализ требований",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Card(
                                        shape = RoundedCornerShape(8.dp),
                                        backgroundColor = Color(226, 62, 52)
                                    ) {
                                        Text(
                                            text = "Лекция",
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
                                    Text(text = "Змеев Денис Олегович")
                                    Text(text = "Компьютерный класс 233, 2-ой корпус")
                                    Text(text = "Группа 972103")

                                }
                                //Время и номер
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "12:25 - 14:00", color = Color(226, 62, 52), fontSize = 20.sp)
                                    Text(text = "3-я пара")

                                }

                            }
                        })

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        shape = RoundedCornerShape(17.dp),
                        elevation = 5.dp,
                        border = BorderStroke(3.dp, Color(78, 76, 221)),
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
                                        text = "Основы машинного обучения",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Card(
                                        shape = RoundedCornerShape(8.dp),
                                        backgroundColor = Color(78, 76, 221)
                                    ) {
                                        Text(
                                            text = "Практика",
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
                                    Text(text = "Красавин Дмитрий Сергеевич")
                                    Text(text = "Компьютерный класс 233, 2-ой корпус")
                                    Text(text = "Группа 972103(1)")

                                }
                                //Время и номер
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "14:45 - 16:20", color = Color(78, 76, 221), fontSize = 20.sp)
                                    Text(text = "4-я пара")

                                }

                            }
                        })

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        shape = RoundedCornerShape(17.dp),
                        elevation = 5.dp,
                        border = BorderStroke(3.dp, Color(78, 76, 221)),
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
                                        text = "Основы машинного обучения",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Card(
                                        shape = RoundedCornerShape(8.dp),
                                        backgroundColor = Color(78, 76, 221)
                                    ) {
                                        Text(
                                            text = "Практика",
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
                                    Text(text = "Красавин Дмитрий Сергеевич")
                                    Text(text = "Компьютерный класс 233, 2-ой корпус")
                                    Text(text = "Группа 972103(1)")

                                }
                                //Время и номер
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "14:45 - 16:20", color = Color(78, 76, 221), fontSize = 20.sp)
                                    Text(text = "4-я пара")

                                }

                            }
                        })

                }

            }


        }

    }

}

