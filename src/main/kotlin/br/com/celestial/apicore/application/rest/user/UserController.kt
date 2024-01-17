package br.com.celestial.apicore.application.rest.user

import br.com.celestial.apicore.application.rest.user.request.UserCreateRequest
import br.com.celestial.apicore.application.rest.user.response.UserCreateResponse
import br.com.celestial.apicore.domain.usecase.user.CreateUserUseCase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class UserController(
    private val create: CreateUserUseCase,
){

    @PostMapping
    fun create(@Valid @RequestBody request: UserCreateRequest): ResponseEntity<UserCreateResponse> =
        created(URI("POST/user")).body(UserCreateResponse(create.execute(request.toEntity()))
    )

    /*
    @PutMapping
    fun update(@Valid @RequestBody request: AddressUpdateRequest) = ok(update.execute(request.toEntity()))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = findById.execute(id)?.let { ok().body(AddressResponse(it)) }

    @GetMapping("/list")
    fun findAll() = ok().body(findAll.execute(null).toAddressResponse() )

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = ok(delete.execute(id.trim()))

    @PostMapping("/paginate")
    fun paginate(@RequestBody pageFilterRequest: AddressPageFilterRequest) =
        ok(paginate.execute(pageFilterRequest.toEntity()).toAddressPageResponse())
     */
}

