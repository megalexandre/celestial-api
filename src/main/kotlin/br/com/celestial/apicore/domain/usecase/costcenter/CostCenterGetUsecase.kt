package br.com.celestial.apicore.domain.usecase.costcenter

import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service

@Service
class CostCenterGetUsecase(
    private val costCenterDataSource: CostCenterDataSource
): Usecase<String, CostCenter?> {

    override fun execute(input: String): CostCenter? = costCenterDataSource.findById(input)


}
