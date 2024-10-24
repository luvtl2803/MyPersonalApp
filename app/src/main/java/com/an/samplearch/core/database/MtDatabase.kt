package com.an.samplearch.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.an.samplearch.core.database.dao.TaskDao
import com.an.samplearch.core.database.model.TaskEntity

@Database(
    entities = [
        TaskEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MtDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}