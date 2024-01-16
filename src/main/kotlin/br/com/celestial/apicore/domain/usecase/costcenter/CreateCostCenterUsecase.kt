package br.com.celestial.apicore.domain.usecase.costcenter

import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.domain.usecase.interfaces.Usecase
import org.springframework.stereotype.Service

@Service
class CreateCostCenterUsecase(
    //private val dataSource: CostCenterDataSource
): Usecase<CostCenter, CostCenter> {
    override fun execute(input: CostCenter): CostCenter = input
        //valid(input).let { dataSource.save(input) }

    /*
    private fun valid(costCenter: CostCenter){ with(costCenter){
        dataSource.findByName(name = name)?.let {
            throw InvalidUsecaseException("duplicated cost center name: $name")
        }}
    }
    */

}
