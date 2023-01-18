package com.memksim.timetracker.di.modules

import android.content.Context
import androidx.room.Room
import com.memksim.timetracker.model.local.daos.ProjectDao
import com.memksim.timetracker.model.local.sources.ProjectDatabase
import com.memksim.timetracker.model.repository.ProjectDatabaseRepository
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

    @Provides
    @Singleton
    fun providesRepository(
        dao: ProjectDao
    ): ProjectDatabaseRepository = ProjectDatabaseRepository(
        dao = dao
    )


}