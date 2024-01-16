package br.com.celestial.apicore.application.rest.costcenter.request

import br.com.celestial.apicore.application.rest.components.adapter.RequestAdapter
import br.com.celestial.apicore.domain.entity.CostCenter
import io.azam.ulidj.ULID.random

data class CostCenterCreateRequest (
    val name: String,

): RequestAdapter<CostCenter> {

    override fun toEntity(): CostCenter = CostCenter(
        id = random(),
        name = name,
    )

}