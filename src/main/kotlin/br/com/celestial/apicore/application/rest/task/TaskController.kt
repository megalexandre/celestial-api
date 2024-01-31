package br.com.celestial.apicore.application.rest.task

import br.com.celestial.apicore.application.rest.task.request.TaskCreateRequest
import br.com.celestial.apicore.application.rest.task.response.TaskCreateResponse
import br.com.celestial.apicore.domain.usecase.task.TaskCreateUsecase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("task", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class TaskController(
    private val create: TaskCreateUsecase,
){
    @PostMapping
    fun create(@Valid @RequestBody request: TaskCreateRequest): ResponseEntity<TaskCreateResponse> =
        ResponseEntity(TaskCreateResponse(create.execute(request.toEntity())), CREATED)

}

