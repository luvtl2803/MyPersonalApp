package com.an.samplearch.core.data.repository

import com.an.samplearch.core.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTask(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
}