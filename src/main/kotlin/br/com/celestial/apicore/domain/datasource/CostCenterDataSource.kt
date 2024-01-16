package br.com.celestial.apicore.domain.datasource

import br.com.celestial.apicore.domain.entity.CostCenter

interface CostCenterDataSource: CustomDataSource<CostCenter> {
    fun findByName(name: String): CostCenter?
    fun existsByName(name: String): Boolean
}