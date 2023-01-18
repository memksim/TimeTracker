package com.memksim.timetracker.model.repository

import com.memksim.timetracker.model.local.daos.ProjectDao
import javax.inject.Inject

class ProjectDatabaseRepository @Inject constructor(
    private val dao: ProjectDao
) {



}