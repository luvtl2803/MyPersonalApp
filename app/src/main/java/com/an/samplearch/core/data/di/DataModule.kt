package com.an.samplearch.core.data.di

import com.an.samplearch.core.data.repository.DefaultTaskRepository
import com.an.samplearch.core.data.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsTaskRepository(taskRepository: DefaultTaskRepository): TaskRepository
}