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
import com.example.composeschedule.network.*
import com.example.composeschedule.network.dto.ClassDto
import com.example.composeschedule.network.dto.GroupDto
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val _email = mutableStateOf("")
    var email: State<String> = _email

    private val _password = mutableStateOf("")
    var password: State<String> = _password

    private val _name = mutableStateOf("")
    var name: State<String> = _name

    private val _group = mutableStateOf("")
    var group: State<String> = _group


    private val _allFilled = mutableStateOf(false)
    var allFilled: State<Boolean> = _allFilled

    private fun check(){
        val email = _email.value
        val password = _password.value
        val name = _name.value
        if (email != null && password != null){
            _allFilled.value = email.isNotEmpty() && password.isNotEmpty()
        }
    }

    fun onEmailChange(newEmail: String){
        _email.value = newEmail
        check()
    }

    fun onNameChange(newName: String){
        _name.value = newName
        check()
    }

    fun onPasswordChange(newPassword: String){
        _password.value = newPassword
        check()
    }

    fun onGroupChange(newGroup: String){
        _group.value = newGroup
        check()
    }

    fun Register(navController: NavController){
        val repositoryAuth = AuthRepository()
        viewModelScope.launch {
            try {
                repositoryAuth.register(
                    RegisterRequestBody(
                        name = _name.value,
                        email = _email.value,
                        password = _password.value.toString(),
                        group_id = _group.value.toInt()
                    )
                ).collect{}
                if(Network.token!!.user.group_id != null){
                    navController.navigate(Screen.ScheduleScreen.passScheduleInfo(Network.token!!.user.group_id.toString(), "GROUP", Network.token!!.user.group_id.toString()))
                }

            }catch(rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {

            }

        }
    }
}

