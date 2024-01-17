package br.com.celestial.apicore.domain.usecase.costcenter

import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CostCenterDeleteUsecase(
    private val costCenterDataSource: CostCenterDataSource,
    private val costCenterGetUsecase: CostCenterGetUsecase
): Usecase<String, Unit> {

    override fun execute(input: String) {
        costCenterGetUsecase.execute(input)?.let {
            costCenterDataSource.delete(it.id)
        }
    }

}
