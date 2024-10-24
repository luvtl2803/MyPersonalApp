package com.an.samplearch.core.model

import com.an.samplearch.core.database.model.TaskEntity

data class Task(
    val id: String,
    val title: String,
    val content: String,
)

fun Task.asTaskEntity() = TaskEntity(
    id = id,
    title = title,
    content = content
)
