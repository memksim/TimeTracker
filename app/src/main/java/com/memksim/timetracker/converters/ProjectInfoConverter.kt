package com.memksim.timetracker.converters

import com.memksim.timetracker.base.ProjectDto
import com.memksim.timetracker.view.ProjectInfo

fun ProjectInfo.toDto(): ProjectDto = ProjectDto(
    projectId = projectId,
    name = name,
    elapsedTime = elapsedTime,
    plannedTime = plannedTime
)

fun ProjectDto.toInfo(): ProjectInfo = ProjectInfo(
    projectId = projectId,
    name = name,
    elapsedTime = elapsedTime,
    plannedTime = plannedTime
)