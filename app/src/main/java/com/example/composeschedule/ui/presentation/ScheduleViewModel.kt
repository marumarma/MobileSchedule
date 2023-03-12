package com.example.composeschedule.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeschedule.network.ClassRepository
import com.example.composeschedule.network.GroupsRepository
import com.example.composeschedule.network.Network
import com.example.composeschedule.network.RegisterRequestBody
import com.example.composeschedule.network.dto.ClassRequestBody
import kotlinx.coroutines.launch

class ScheduleViewModel : ViewModel() {
    private val _haveRequest = mutableStateOf(false)
    var haveRequest : State<Boolean> = _haveRequest

    var clas = Network.clas
    fun getClass(){
        val repository = ClassRepository()
        viewModelScope.launch {
            repository.getClassList(
                date_start = "2023-03-1",
                group_id = 1,
                teacher_id = 1,
                classroom_id = 1
            )
            clas = Network.clas
            _haveRequest.value = true
        }
    }
}

