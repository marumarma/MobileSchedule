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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.Screen
import com.example.composeschedule.network.dto.GroupDto

@OptIn(ExperimentalMaterialApi::class)
@Composable


fun RegisterScreen(navController: NavController) {
    val viewModel : GroupsListViewModel = viewModel()
    val registerViewModel: RegisterViewModel = viewModel()
    val haveRequest by remember {viewModel.haveRequest}

    if(!haveRequest){
        viewModel.getGroups()
    }
    if(haveRequest){
        val state = viewModel.groups.collectAsState().value
        var options = mutableListOf<GroupDto>()
        var ids = mutableListOf<Int>()
        if (state.size > 0){
            for(i in 0..state.size-1){
                options.add(state[i])
                ids.add(state[i].id)
            }
        }
        var selectedOptionText by remember { mutableStateOf(options[0]) }


        var expanded by remember { mutableStateOf(false) }



        var nameValue by remember {
            mutableStateOf("")

        }
        var emailValue by remember {
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
                            value = selectedOptionText.name,
                            onValueChange = { },
                            label = { Text("Выберите группу") },
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
                                        registerViewModel.onGroupChange(selectedOptionText.id.toString())
                                        expanded = false
                                    },
                                ) {
                                    Text(text = selectionOption.name +" (" + selectionOption.id.toString() + ")")
                                }
                            }
                        }
                    }

                    nameField(registerViewModel)
                    emailField(registerViewModel )
                    passwordField(registerViewModel)
                    Reg(registerViewModel, navController)


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



}

@Composable
fun nameField(viewModel: RegisterViewModel){
    val name: String by remember { viewModel.name }
    TextField(
        value = name,
        onValueChange = {viewModel.onNameChange(it)},
        placeholder = { Text(text = "ФИО") },
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Composable
fun emailField(viewModel: RegisterViewModel){
    val email: String by remember { viewModel.email }
    TextField(
        value = email,
        onValueChange = { viewModel.onEmailChange(it) },
        placeholder = { Text(text = "E-mail") },
        modifier = Modifier.padding(top = 20.dp)
    )
}

@Composable
fun passwordField(viewModel: RegisterViewModel){
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
fun Reg(registerViewModel: RegisterViewModel, navController: NavController){
    val registerIsFilled: Boolean by remember {registerViewModel.allFilled}
    Button(
        onClick = {registerViewModel.Register(navController)},
        enabled = registerIsFilled,
        modifier = Modifier
            .background(Color.White)
            .shadow(0.dp)
            .width(200.dp)
            .height(60.dp)
            .padding(top = 20.dp),

        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0, 108, 190)),
        border = BorderStroke(0.dp, Color(0, 108, 190)),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = "Зарегистрироваться", color = Color.White)
    }
}
