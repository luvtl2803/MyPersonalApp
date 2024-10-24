package com.an.samplearch.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.an.samplearch.core.model.Task

@Entity(tableName = "task_entity")
data class TaskEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val content: String
)

fun TaskEntity.asTask() = Task(
    id = id,
    title = title,
    content = content
)

fun List<TaskEntity>.mapToTasks() = map {
    it.asTask()
}
