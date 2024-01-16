package br.com.celestial.apicore.application.rest.costcenter

import br.com.celestial.apicore.application.rest.costcenter.request.CostCenterCreateRequest
import br.com.celestial.apicore.application.rest.costcenter.response.CostCenterCreateResponse
import br.com.celestial.apicore.application.rest.costcenter.response.CostCenterGetResponse
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterCreateUsecase
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterGetUsecase
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
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
){

    @PostMapping
    fun create(@Valid @RequestBody request: CostCenterCreateRequest): ResponseEntity<CostCenterCreateResponse> =
        created(URI("POST/CostCenter")).body(CostCenterCreateResponse(create.execute(request.toEntity()))
    )

    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String) =
        get.execute(id)?.let {
            CostCenterGetResponse(it)
        }


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

