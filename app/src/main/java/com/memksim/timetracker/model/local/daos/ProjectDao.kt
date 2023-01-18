package com.memksim.timetracker.model.local.daos

import androidx.room.*
import com.memksim.timetracker.model.local.entity.ProjectTable
import io.reactivex.rxjava3.core.Single

@Dao
interface ProjectDao {

    @Query("select * from projects where _id = :projectId")
    fun getProjectById(projectId: Int): Single<ProjectTable>

    @Query("select * from projects")
    fun getProjects(): Single<List<ProjectTable>>

    @Insert
    fun insertProject(project: ProjectTable)

    @Update
    fun updateProject(project: ProjectTable)

    @Delete
    fun deleteProject(project: ProjectTable)
}