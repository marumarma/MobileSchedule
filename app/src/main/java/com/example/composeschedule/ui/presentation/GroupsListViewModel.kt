package com.example.composeschedule.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeschedule.network.GroupsRepository
import com.example.composeschedule.network.Network
import com.example.composeschedule.network.dto.ClassDto
import com.example.composeschedule.network.dto.GroupDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GroupsListViewModel : ViewModel() {
    private val _haveRequest = mutableStateOf(false)
    var haveRequest : State<Boolean> = _haveRequest
    var groups = MutableStateFlow<List<GroupDto>>(listOf())

    fun getGroups(){
        val repository = GroupsRepository()
        viewModelScope.launch {
            repository.getGroupsList()
            groups.value = Network.groups!!
            _haveRequest.value = true
        }
    }
}

