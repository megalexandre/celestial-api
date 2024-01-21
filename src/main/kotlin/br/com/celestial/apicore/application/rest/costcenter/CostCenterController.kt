package br.com.celestial.apicore.application.rest.costcenter

import br.com.celestial.apicore.application.rest.costcenter.request.CostCenterCreateRequest
import br.com.celestial.apicore.application.rest.costcenter.response.CostCenterCreateResponse
import br.com.celestial.apicore.application.rest.costcenter.response.CostCenterFindAllResponse
import br.com.celestial.apicore.application.rest.costcenter.response.CostCenterGetResponse
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterCreateUsecase
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterDeleteUsecase
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterFindAllUsecase
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterGetUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
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
@RequestMapping("costcenter", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class CostCenterController(
    private val create: CostCenterCreateUsecase,
    private val get: CostCenterGetUsecase,
    private val findAll: CostCenterFindAllUsecase,
    private val delete: CostCenterDeleteUsecase,
){
    @PostMapping
    fun create(@Valid @RequestBody request: CostCenterCreateRequest): ResponseEntity<CostCenterCreateResponse> =
        created(URI("POST/CostCenter")).body(CostCenterCreateResponse(create.execute(request.toEntity())))

    @GetMapping
    fun getAll(): ResponseEntity<List<CostCenterFindAllResponse>> =
        ok(findAll.execute(Unit)?.let { c ->  c.map {  CostCenterFindAllResponse(it) } } )

    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String) :ResponseEntity<CostCenterGetResponse> =
        ok(get.execute(id)?.let { CostCenterGetResponse(it)} )

    @DeleteMapping("/{id}")
    fun delete(@Valid @PathVariable id: String): ResponseEntity.HeadersBuilder<*> {
        delete.execute(id)
        return noContent()
    }
}