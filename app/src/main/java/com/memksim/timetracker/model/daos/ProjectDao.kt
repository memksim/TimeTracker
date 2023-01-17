package com.memksim.timetracker.model.daos

import androidx.room.*
import com.memksim.timetracker.model.entity.ProjectTable

@Dao
interface ProjectDao {

    @Query("select * from projects where _id = :projectId")
    suspend fun getProjectById(projectId: Int): ProjectTable

    @Query("select * from projects")
    suspend fun getProjects(): List<ProjectTable>

    @Insert
    suspend fun insertProject(project: ProjectTable)

    @Update
    suspend fun updateProject(project: ProjectTable)

    @Delete
    suspend fun deleteProject(project: ProjectTable)
}