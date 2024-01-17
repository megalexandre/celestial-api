package br.com.celestial.apicore.application.rest.costcenter.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.domain.entity.CostCenter
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class CostCenterGetResponse (
    val id: String,
    val name: String,
    val total: BigDecimal? = ZERO,
): ResponseAdapter<CostCenter, CostCenterGetResponse> {
    constructor(costCenter: CostCenter) : this(
        id = costCenter.id,
        name = costCenter.name,
        total = costCenter.total
    )
    override fun toResponse(entity: CostCenter): CostCenterGetResponse = CostCenterGetResponse(entity)
}



