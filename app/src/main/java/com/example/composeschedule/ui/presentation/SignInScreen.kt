package com.example.composeschedule.ui.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.Screen

@Composable

fun SignInScreen(navController: NavController) {
    val signInViewModel: SignInViewModel = viewModel()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White))
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = { navController.navigate(Screen.MainScreen.route) },
                modifier = Modifier.padding(top = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color(0, 108, 190),
                ),
            ) {
                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = "Назад",
                        color = Color(0, 108, 190),
                        fontSize = 20.sp
                    )
                }
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(text = "Вход в ТГУ.Аккаунт", fontSize = 30.sp)
                emailField(signInViewModel)
                passwordField(signInViewModel)
                SignInComeIn(signInViewModel, navController)
                Text(
                    text = "Продолжить без авторизации",
                    color = Color(0, 108, 190),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .clickable(
                            enabled = true,
                            onClick = { navController.navigate(Screen.ChoosingScreen.route) })
                )

            }

        }
    }
}

@Composable
fun emailField(viewModel: SignInViewModel){
    val email: String by remember { viewModel.email }
    TextField(
        value = email,
        onValueChange = { viewModel.onEmailChange(it) },
        placeholder = { Text(text = "E-mail") },
        modifier = Modifier.padding(top = 20.dp)
    )
}

@Composable
fun passwordField(viewModel: SignInViewModel){
    val password: String by remember { viewModel.password }
    TextField(
        value = password,
        onValueChange = { viewModel.onPasswordChange(it) },
        placeholder = { Text(text = "Пароль") },
        modifier = Modifier.padding(top = 20.dp),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true
    )
}

@Composable
fun SignInComeIn(signInViewModel: SignInViewModel, navController: NavController){
    val signInIsFilled: Boolean by remember {signInViewModel.allFilled}
    Button(
        onClick = {signInViewModel.logIn(navController)},
        enabled = signInIsFilled,
        modifier = Modifier
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
}