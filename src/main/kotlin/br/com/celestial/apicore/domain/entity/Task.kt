package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.enums.TaskStatus
import java.time.LocalDateTime

data class Task (
    val id: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val createdAt: LocalDateTime,
)
