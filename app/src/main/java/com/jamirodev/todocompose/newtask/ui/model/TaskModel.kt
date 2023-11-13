package com.jamirodev.todocompose.newtask.ui.model

data class TaskModel(val id:Long = System.currentTimeMillis(), val task:String, var selected:Boolean = false)
