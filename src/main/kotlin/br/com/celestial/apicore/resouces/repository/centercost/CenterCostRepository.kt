package br.com.celestial.apicore.resouces.repository.centercost

import br.com.celestial.apicore.resouces.document.CostCenterDocument
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface CenterCostRepository : MongoRepository<CostCenterDocument, String>{
    fun findByName(name: String): Optional<CostCenterDocument>

}