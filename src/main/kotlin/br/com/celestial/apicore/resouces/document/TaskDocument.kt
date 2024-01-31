package br.com.celestial.apicore.resouces.document

import br.com.celestial.apicore.common.enums.TaskStatus
import br.com.celestial.apicore.resouces.document.interfaces.DocumentItem
import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "task")
data class TaskDocument(

    @Id
    val id: String,

    val title: String,

    val description: String,

    val status: TaskStatus,

    val createdAt: LocalDateTime,

): DocumentItem