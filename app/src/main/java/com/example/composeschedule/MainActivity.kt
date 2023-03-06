package com.example.composeschedule

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeschedule.ui.theme.ComposeScheduleTheme
//ddididdi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(modifier = Modifier.background(Color.White))
            {

                Column(modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly)
                {
                    Text(text = "Добро пожаловать!",
                        color = Color(0, 108, 190),
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(top = 35.dp, start = 35.dp))
                    Text(text = "Здесь ты всегда сможешь посмотреть свое актуальное расписание занятий",
                    fontSize = 23.sp,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 35.dp))
                }

                Column(modifier = Modifier.background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Image(painterResource(id = R.drawable.cat), contentDescription = null,
                    Modifier.size(450.dp).padding(20.dp))

                    Button(onClick = { /*TODO*/ },
                        Modifier
                            .background(Color.White)
                            .shadow(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color(0, 108, 190)),
                        shape = RoundedCornerShape(18.dp)
                    )

                    {
                        Row(modifier = Modifier
                            .width(250.dp)
                            .height(35.dp),
                            verticalAlignment = Alignment.CenterVertically)
                        {
                            Text(text = "Войти через ТГУ.Аккаунт ",
                                color = Color(0, 108, 190),
                                fontSize = 15.sp)
                            Image(painterResource(id = R.drawable.tsu),
                                contentDescription = null,
                                Modifier.width(50.dp))
                        }
                    }

                    Text( modifier = Modifier.padding(top = 15.dp), text = "Продолжить без авторизации",
                        textDecoration = TextDecoration.Underline,
                        color = Color(0, 108, 190),
                        fontSize = 14.sp)
                }
            }
        }
    }
}
