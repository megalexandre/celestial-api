package br.com.celestial.apicore.application.rest.costcenter.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.domain.entity.CostCenter

data class CostCenterCreateResponse (
    val id: String,
): ResponseAdapter<CostCenter, CostCenterCreateResponse> {
    constructor(costCenter: CostCenter) : this(
        id = costCenter.id,
    )
    override fun toResponse(entity: CostCenter): CostCenterCreateResponse =  CostCenterCreateResponse(entity)
}



