package com.example.composeschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeschedule.ui.theme.ComposeScheduleTheme

class SingnInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeScheduleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var value by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 10.dp)
            )
            Text(
                text = "Назад",
                color = Color(0, 108, 190),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(text = "Вход в ТГУ.Аккаунт", fontSize = 30.sp)
            TextField(value = value, onValueChange = { newText ->
                value = newText
            }, placeholder = { Text(text = "E-mail") }, modifier = Modifier.padding(top = 20.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Пароль") },
                modifier = Modifier.padding(top = 10.dp)
            )
            Button(
                onClick = {}, Modifier
                    .background(Color.White)
                    .shadow(0.dp)
                    .width(100.dp)
                    .height(60.dp)
                    .padding(top = 20.dp),

                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0, 108, 190)),
                border = BorderStroke(0.dp, Color(0, 108, 190)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Войти", color = Color.White)
            }
            Text(
                text = "Продолжить без авторизации",
                color = Color(0, 108, 190),
                textDecoration = TextDecoration.Underline,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 15.dp)
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeScheduleTheme {
        Greeting()
    }
}




