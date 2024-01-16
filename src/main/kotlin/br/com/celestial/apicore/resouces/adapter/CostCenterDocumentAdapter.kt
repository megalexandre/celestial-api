package br.com.celestial.apicore.resouces.adapter

import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.resouces.document.CostCenterDocument

fun CostCenterDocument.toCostCenter() = CostCenter(
    id = this.id,
    name = this.name
)
