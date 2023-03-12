package com.example.composeschedule.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeschedule.network.GroupsRepository
import com.example.composeschedule.network.Network
import com.example.composeschedule.network.dto.ClassroomsRepository
import kotlinx.coroutines.launch

class ClassroomsListViewModel : ViewModel() {
    private val _haveRequest = mutableStateOf(false)
    var haveRequest : State<Boolean> = _haveRequest

    var classrooms = Network.classrooms
    fun getClassrooms(){
        val repository = ClassroomsRepository()
        viewModelScope.launch {
            repository.getClassroomsList()
            classrooms = Network.classrooms
            _haveRequest.value = true
        }
    }
}

