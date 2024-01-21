package br.com.celestial.apicore.application.rest.costcenter.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.common.util.toMonetary
import br.com.celestial.apicore.domain.entity.CostCenter
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class CostCenterFindAllResponse (
    val id: String,
    val name: String,
    val total: BigDecimal? = ZERO,
    val totalCurrentMonth: BigDecimal? = ZERO,

): ResponseAdapter<CostCenter, CostCenterFindAllResponse> {
    constructor(costCenter: CostCenter) : this(
        id = costCenter.id,
        name = costCenter.name,
        total = costCenter.total.toMonetary(),
        totalCurrentMonth = costCenter.totalCurrentMonth.toMonetary()
    )
    override fun toResponse(entity: CostCenter): CostCenterFindAllResponse = CostCenterFindAllResponse(entity)
}



