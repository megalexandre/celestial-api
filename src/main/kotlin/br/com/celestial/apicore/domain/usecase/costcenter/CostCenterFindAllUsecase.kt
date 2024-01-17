package br.com.celestial.apicore.domain.usecase.costcenter

import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CostCenterFindAllUsecase(
    private val costCenterDataSource: CostCenterDataSource
): Usecase<Unit, List<CostCenter>?> {

    override fun execute(input: Unit): List<CostCenter>? = costCenterDataSource.findAll()

}
