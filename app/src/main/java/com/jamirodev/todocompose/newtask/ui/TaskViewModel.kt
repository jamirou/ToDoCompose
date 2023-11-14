package com.jamirodev.todocompose.newtask.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamirodev.todocompose.newtask.domain.AddTaskUseCase
import com.jamirodev.todocompose.newtask.domain.GetTaskUseCase
import com.jamirodev.todocompose.newtask.ui.UiStates.*
import com.jamirodev.todocompose.newtask.ui.model.TaskModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    getTaskUseCase: GetTaskUseCase
) : ViewModel() {

    val uiState: StateFlow<UiStates> = getTaskUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

//    private val _task = mutableStateListOf<TaskModel>()
//    val task: List<TaskModel> = _task

    fun onDialogClosed() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false


        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
//UPDATE CHECKBOX
    //        val index = _task.indexOf(taskModel)
//        _task[index] = _task[index].let {
//            it.copy(selected = !it.selected)
//        }
    }

    fun onItemRemove(taskModel: TaskModel) {
        //DELETE ITEM
//        val task = _task.find { it.id == taskModel.id }
//        _task.remove(task)
    }

}