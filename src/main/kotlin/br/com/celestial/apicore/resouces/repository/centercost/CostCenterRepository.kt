package br.com.celestial.apicore.resouces.repository.centercost

import br.com.celestial.apicore.resouces.document.CostCenterDocument
import java.util.Optional
import org.springframework.data.mongodb.repository.MongoRepository

interface CostCenterRepository : MongoRepository<CostCenterDocument, String>{
    fun findByName(name: String): Optional<CostCenterDocument>

}