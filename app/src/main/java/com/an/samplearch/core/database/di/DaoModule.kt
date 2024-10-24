package com.an.samplearch.core.database.di

import com.an.samplearch.core.database.MtDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    fun providesTaskDao(database: MtDatabase) = database.taskDao()
}