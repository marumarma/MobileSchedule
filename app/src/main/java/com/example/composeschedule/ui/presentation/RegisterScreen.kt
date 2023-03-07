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
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable


fun RegisterScreen(navController: NavController) {

    val options = listOf("Студент", "Преподаватель")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }


    var value by remember {
        mutableStateOf("")

    }

    var passValue by remember {
        mutableStateOf((""))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
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
                Text(text = "Регистрация", fontSize = 30.sp)

                //Выпадающий список роли
                ExposedDropdownMenuBox(modifier = Modifier.padding(top = 20.dp),
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = selectedOptionText,
                        onValueChange = { },
                        label = { Text("Выберите роль") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        options.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionText = selectionOption
                                    expanded = false
                                }
                            ) {
                                Text(text = selectionOption)
                            }
                        }
                    }
                }


                TextField(
                    value = value,
                    onValueChange = { newText ->
                        value = newText
                    },
                    placeholder = { Text(text = "E-mail") },
                    modifier = Modifier.padding(top = 10.dp)
                )
                TextField(
                    value = passValue,
                    onValueChange = { newText ->
                        passValue = newText
                    },
                    placeholder = { Text(text = "Пароль") },
                    modifier = Modifier.padding(top = 10.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
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