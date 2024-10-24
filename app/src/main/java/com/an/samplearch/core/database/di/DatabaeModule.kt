package com.an.samplearch.core.database.di

import android.content.Context
import androidx.room.Room
import com.an.samplearch.core.database.MtDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesMtDatabase(
        @ApplicationContext context: Context
    ): MtDatabase = Room.databaseBuilder(
        context,
        MtDatabase::class.java,
        "mt-database"
    ).build()
}