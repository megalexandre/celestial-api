package br.com.celestial.apicore.domain.usecase.costcenter

import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CostCenterCreateUsecase(
    private val costCenterDataSource: CostCenterDataSource
): Usecase<CostCenter, CostCenter> {
    override fun execute(input: CostCenter): CostCenter =
        valid(input).let {
            costCenterDataSource.save(input)
        }

    private fun valid(costCenter: CostCenter){ with(costCenter){
        costCenterDataSource.findByName(name = name)?.let {
            throw InvalidUsecaseException("duplicated cost center name: $name")
        }}
    }

}
