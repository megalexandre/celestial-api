package br.com.celestial.apicore.domain.dto.task

import br.com.celestial.apicore.common.enums.TaskStatus

class TaskUpdateStatus (
    val id: String,
    val status: TaskStatus,
)