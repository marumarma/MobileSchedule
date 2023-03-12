package com.example.composeschedule.ui.presentation


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeschedule.R
import com.example.composeschedule.navigation.Screen
import com.example.composeschedule.network.Network.groups


@Composable

fun GroupsListScreen(navController: NavController) {
    val viewModel : GroupsListViewModel = viewModel()
    viewModel.getGroups()
    val ready: State<Boolean> = remember { viewModel.haveRequest }
    if (ready.value){
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(id = R.drawable.step2),
                        contentDescription = null,
                        modifier = Modifier.size(width = 350.dp, height = 50.dp)
                    )
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Выберите группу",
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 20.dp, start = 35.dp)
                            .clickable(onClick = {
                                navController.navigate(
                                    Screen.ScheduleScreen.route
                                )
                            })
                    )

                    /*SearchBar(text = "", onTextChange = {}, onCloseClicked = { /*TODO*/ }) {

                    }*/


                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(245, 245, 245))){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp)
                            .verticalScroll(
                                rememberScrollState()
                            )

                    ) {
                        for (i in 0..viewModel.groups!!.size-1) {
                            Text(
                                text = viewModel.groups!![i].name,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(vertical = 18.dp)
                                    .padding(start = 10.dp),
                                color = Color.Gray
                            )
                            Divider(color = Color.Gray, thickness = 1.dp)
                        }

                    }

                }


            }

        }
    }
}



/*fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit = {},
    onCloseClicked: () -> Unit = {},
    onSearchClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .width(375.dp)
            .height(50.dp)
            .padding(start = 35.dp),
        color = Color(247, 247, 247),
        shape = RoundedCornerShape(15.dp)
    ) {
        TextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    text = "Введите...",
                    color = Color.Black
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(modifier = Modifier.alpha(ContentAlpha.disabled), onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            },
            trailingIcon = {
                IconButton(modifier = Modifier.alpha(ContentAlpha.disabled), onClick = {
                    if (text.isNotEmpty()) {
                        onTextChange("")
                    }else{
                        onCloseClicked()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        tint = Color.Black
                    )

                }
            },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {onSearchClicked()})
        )

    }
}*/