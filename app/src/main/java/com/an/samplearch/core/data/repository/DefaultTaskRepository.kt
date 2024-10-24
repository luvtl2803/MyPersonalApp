package com.an.samplearch.core.data.repository

import com.an.samplearch.core.database.dao.TaskDao
import com.an.samplearch.core.database.model.mapToTasks
import com.an.samplearch.core.model.Task
import com.an.samplearch.core.model.asTaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultTaskRepository @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getTask(): Flow<List<Task>> {
        return taskDao.getTask().map { it.mapToTasks() }
    }

    override suspend fun insertTask(task: Task) {
        withContext(Dispatchers.IO) {
            taskDao.insertTask(task.asTaskEntity())
        }
    }
}