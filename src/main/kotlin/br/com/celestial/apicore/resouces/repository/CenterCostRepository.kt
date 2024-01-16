package br.com.celestial.apicore.resouces.repository

import br.com.celestial.apicore.resouces.document.CostCenterDocument
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface CenterCostRepository : MongoRepository<CostCenterDocument, String>{
    fun findByNameNormalized(name: String): Optional<CostCenterDocument>

}