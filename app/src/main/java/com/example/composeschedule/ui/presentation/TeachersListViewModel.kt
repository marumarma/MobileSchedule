package com.example.composeschedule.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeschedule.network.GroupsRepository
import com.example.composeschedule.network.Network
import com.example.composeschedule.network.TeachersRepository
import kotlinx.coroutines.launch

class TeachersListViewModel : ViewModel() {
    private val _haveRequest = mutableStateOf(false)
    var haveRequest : State<Boolean> = _haveRequest

    var teachers = Network.teachers
    fun getTeachers(){
        val repository = TeachersRepository()
        viewModelScope.launch {
            repository.getTeachersList()
            teachers = Network.teachers
            _haveRequest.value = true
        }
    }
}

