package com.memksim.timetracker.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectTable(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val projectId: Int,
    val name: String,
    @ColumnInfo(name = "elapsed_time")
    val elapsedTime: String,
    @ColumnInfo(name = "planned_time")
    val plannedTime: String
)
