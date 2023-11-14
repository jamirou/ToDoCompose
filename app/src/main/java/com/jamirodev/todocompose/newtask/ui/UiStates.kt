package com.jamirodev.todocompose.newtask.ui

import com.jamirodev.todocompose.newtask.ui.model.TaskModel

sealed interface UiStates {
    object Loading:UiStates
    data class Error(val throwable:Throwable):UiStates
    data class Success(val task:List<TaskModel>):UiStates
}