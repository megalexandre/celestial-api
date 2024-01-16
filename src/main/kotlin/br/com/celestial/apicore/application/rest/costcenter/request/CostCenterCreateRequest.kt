package br.com.celestial.apicore.application.rest.costcenter.request

import br.com.celestial.apicore.application.rest.components.adapter.RequestAdapter
import br.com.celestial.apicore.domain.entity.CostCenter
import io.azam.ulidj.ULID.random
import jakarta.validation.constraints.NotEmpty

data class CostCenterCreateRequest (
    @field:NotEmpty(message = "campo nome não pode ser vazio")
    val name: String,
): RequestAdapter<CostCenter> {

    override fun toEntity(): CostCenter = CostCenter(
        id = random(),
        name = name,
    )

}