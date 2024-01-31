package br.com.celestial.apicore.application.rest.task.request

import br.com.celestial.apicore.application.rest.components.adapter.RequestAdapter
import br.com.celestial.apicore.common.enums.TaskStatus
import br.com.celestial.apicore.domain.entity.Task
import io.azam.ulidj.ULID.random
import java.time.LocalDateTime

data class TaskCreateRequest (
    val title: String,
    val description: String ? = null ,
    val status: TaskStatus,

): RequestAdapter<Task> {

    override fun toEntity(): Task = Task(
        id = random(),
        createdAt = LocalDateTime.now(),
        title = this.title,
        status = this.status,
        description = this.description ?: "",
    )

}
