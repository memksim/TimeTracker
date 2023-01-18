package com.memksim.timetracker.converters

import com.memksim.timetracker.base.ProjectDto
import com.memksim.timetracker.model.local.entity.ProjectTable

fun ProjectTable.toDto(): ProjectDto = ProjectDto(
    projectId = projectId,
    name = name,
    elapsedTime = elapsedTime,
    plannedTime = plannedTime
)

fun ProjectDto.toModel(): ProjectTable = ProjectTable(
    projectId = projectId,
    name = name,
    elapsedTime = elapsedTime,
    plannedTime = plannedTime
)