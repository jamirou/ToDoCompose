package com.jamirodev.todocompose.newtask.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamirodev.todocompose.newtask.ui.model.TaskModel
import javax.inject.Inject

class TaskViewModel @Inject constructor():ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog:LiveData<Boolean> = _showDialog

    private val _task = mutableListOf<TaskModel>()
    val task:List<TaskModel> = _task

    fun onDialogClosed() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false
        _task.add(TaskModel(task = task))
        Log.i("Jamiro", task)
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {

    }


}