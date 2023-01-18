package com.memksim.timetracker.base

data class ProjectDto(
    val projectId: Int,
    val name: String,
    val elapsedTime: String,
    val plannedTime: String
)
