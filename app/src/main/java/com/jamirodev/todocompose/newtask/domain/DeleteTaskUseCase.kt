package com.jamirodev.todocompose.newtask.domain

import com.jamirodev.todocompose.newtask.data.TaskRepository
import com.jamirodev.todocompose.newtask.ui.model.TaskModel
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.delete(taskModel)
    }
}