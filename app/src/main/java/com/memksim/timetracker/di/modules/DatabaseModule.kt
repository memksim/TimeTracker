package com.memksim.timetracker.di.modules

import android.content.Context
import androidx.room.Room
import com.memksim.timetracker.model.daos.ProjectDao
import com.memksim.timetracker.model.sources.ProjectDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        context: Context
    ): ProjectDatabase = Room.databaseBuilder(
        context = context,
        klass = ProjectDatabase::class.java,
        name = "ProjectsDatabase"
    ).build()

    @Provides
    @Singleton
    fun providesDao(
        db: ProjectDatabase
    ): ProjectDao = db.getDao()

}