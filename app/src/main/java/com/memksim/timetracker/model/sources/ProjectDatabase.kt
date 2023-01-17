package com.memksim.timetracker.model.sources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memksim.timetracker.model.daos.ProjectDao
import com.memksim.timetracker.model.entity.ProjectTable

@Database(entities = [ProjectTable::class], version = 1, exportSchema = false)
abstract class ProjectDatabase: RoomDatabase() {
    abstract fun getDao(): ProjectDao
}