package com.jamirodev.todocompose.newtask.domain

import com.jamirodev.todocompose.newtask.data.TaskRepository
import com.jamirodev.todocompose.newtask.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks

}