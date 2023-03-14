package com.example.composeschedule.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.composeschedule.navigation.Screen
import com.example.composeschedule.network.AuthRepository
import com.example.composeschedule.network.GroupsRepository
import com.example.composeschedule.network.LoginRequestBody
import com.example.composeschedule.network.Network
import com.example.composeschedule.network.dto.ClassDto
import com.example.composeschedule.network.dto.GroupDto
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    private val _email = mutableStateOf("")
    var email: State<String> = _email

    private val _password = mutableStateOf("")
    var password: State<String> = _password


    private val _allFilled = mutableStateOf(false)
    var allFilled: State<Boolean> = _allFilled

    private fun check(){
        val email = _email.value
        val password = _password.value
        if (email != null && password != null){
            _allFilled.value = email.isNotEmpty() && password.isNotEmpty()
        }
    }

    fun onEmailChange(newEmail: String){
        _email.value = newEmail
        check()
    }

    fun onPasswordChange(newPassword: String){
        _password.value = newPassword
        check()
    }

    fun logIn(navController: NavController){
        val repositoryAuth = AuthRepository()
        viewModelScope.launch {
            try {
                repositoryAuth.login(
                    LoginRequestBody(
                        email = _email.value.toString(),
                        password = _password.value.toString()
                    )
                ).collect{}
                if(Network.token!!.user.group != null){
                    navController.navigate(Screen.ScheduleScreen.passScheduleInfo(Network.token!!.user.group_id.toString(), "GROUP", Network.token!!.user.group!!.name))
                }
                if(Network.token!!.user.teacher != null){
                    navController.navigate(Screen.ScheduleScreen.passScheduleInfo(Network.token!!.user.teacher_id.toString(), "TEACHER", Network.token!!.user.teacher!!.name))
                }

            }catch(rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {

            }

        }
    }
}

