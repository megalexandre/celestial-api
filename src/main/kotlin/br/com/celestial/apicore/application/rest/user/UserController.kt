package br.com.celestial.apicore.application.rest.user

import br.com.celestial.apicore.application.rest.user.request.UserCreateRequest
import br.com.celestial.apicore.application.rest.user.response.UserCreateResponse
import br.com.celestial.apicore.application.rest.user.response.UserGetResponse
import br.com.celestial.apicore.domain.usecase.user.UserCreateUsecase
import br.com.celestial.apicore.domain.usecase.user.UserDeleteUsecase
import br.com.celestial.apicore.domain.usecase.user.UserFindAllUsecase
import br.com.celestial.apicore.domain.usecase.user.UserGetUsecase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class UserController(
    private val create: UserCreateUsecase,
    private val delete: UserDeleteUsecase,
    private val get: UserGetUsecase,
    private val findAll: UserFindAllUsecase,
){
    @PostMapping
    fun create(@Valid @RequestBody request: UserCreateRequest): ResponseEntity<UserCreateResponse> =
        ResponseEntity(UserCreateResponse(create.execute(request.toEntity())), CREATED)

    @GetMapping
    fun getAll(): ResponseEntity<List<UserGetResponse>> =
        ok(findAll.execute(Unit)?.let { c -> c.map { UserGetResponse(it) } })

    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String) :ResponseEntity<UserGetResponse> =
        ok(UserGetResponse(get.execute(id)))

    @DeleteMapping("/{id}")
    fun delete(@Valid @PathVariable id: String): ResponseEntity.HeadersBuilder<*> {
        delete.execute(id)
        return noContent()
    }
}

