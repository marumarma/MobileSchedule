package com.example.composeschedule.ui.presentation

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.composeschedule.network.ClassRepository
import com.example.composeschedule.network.GroupsRepository
import com.example.composeschedule.network.Network
import com.example.composeschedule.network.RegisterRequestBody
import com.example.composeschedule.network.dto.ClassDto
import com.example.composeschedule.network.dto.ClassRequestBody
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*

class ScheduleViewModel : ViewModel() {
     var schedule_id = ""
     var schedule_type = ""
    var schedule_name = ""
    var haveRequest = mutableStateOf(false)
    val repository = ClassRepository()
    var clas = MutableStateFlow<List<ClassDto>>(listOf())
    val classLiveData = MutableLiveData(clas)


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
            clas.value = Network.clas
            haveRequest.value = true
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
            clas.value = Network.clas
            haveRequest.value = true
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
            clas.value = Network.clas
            haveRequest.value = true
        }
    }

    @SuppressLint
    fun getDate(): Date {
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.SUNDAY

        var selDay = calendar.get(Calendar.DAY_OF_WEEK)

        calendar.add(Calendar.WEEK_OF_MONTH, 0)
        calendar[Calendar.DAY_OF_WEEK] = calendar.firstDayOfWeek

        val days: ArrayList<Date> = arrayListOf()

        days.add(calendar.time)

        return days[0]
    }
}
