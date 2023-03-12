package com.example.composeschedule.ui.presentation

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
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
import java.util.*

class ScheduleViewModel : ViewModel() {
    private val _haveRequest = mutableStateOf(false)
     var schedule_id = ""
     var schedule_type = ""
    var schedule_name = ""
    var haveRequest : State<Boolean> = _haveRequest
    val repository = ClassRepository()
    var clas = Network.clas
    @SuppressLint("SimpleDateFormat")
    fun getClass(id: String = schedule_id, type: String = schedule_type, name : String = schedule_name, data : Date){
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dataString = simpleDateFormat.format(data)

        schedule_id = id
        schedule_type = type
        schedule_name = name

        when(type){
            "GROUP" -> getgr(id, dataString)
            "TEACHER" -> gette(id, dataString)
            "CLASSROOM" -> getcl(id, dataString)
        }
    }
    private fun getgr(id: String, data : String){
        viewModelScope.launch {
            repository.getClassList(
                date_start = data,
                group_id = id.toInt(),
                teacher_id = null,
                classroom_id = null
            )
            clas = Network.clas
            _haveRequest.value = true
        }
    }
    private fun gette(id: String,  data : String){
        viewModelScope.launch {
            repository.getClassList(
                date_start = data,
                group_id = null,
                teacher_id = id.toInt(),
                classroom_id = null
            )
            clas = Network.clas
            _haveRequest.value = true
        }
    }
    private fun getcl(id: String,  data : String){
        viewModelScope.launch {
            repository.getClassList(
                date_start = data,
                group_id = null,
                teacher_id = null,
                classroom_id = id.toInt()
            )
            clas = Network.clas
            _haveRequest.value = true
        }
    }
}
