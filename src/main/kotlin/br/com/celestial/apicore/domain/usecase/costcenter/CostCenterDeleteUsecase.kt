package br.com.celestial.apicore.domain.usecase.costcenter

import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CostCenterDeleteUsecase(
    private val costCenterDataSource: CostCenterDataSource,
    private val costCenterGetUsecase: CostCenterGetUsecase
): Usecase<String, Boolean> {

    override fun execute(input: String): Boolean =
        costCenterGetUsecase.execute(input)?.let {
            return when(it.expenses == null){
                true -> {
                    costCenterDataSource.delete(it.id)
                    true
                }
                false -> false
            }
        } ?: false

    /*
    override fun execute(input: CostCenter): CostCenter =
        valid(input).let {
            costCenterDataSource.save(input)
        }

    private fun valid(costCenter: CostCenter){ with(costCenter){
        costCenterDataSource.findByName(name = name)?.let {
            throw InvalidUsecaseException("duplicated cost center name: $name")
        }}
    }
    * */


}
