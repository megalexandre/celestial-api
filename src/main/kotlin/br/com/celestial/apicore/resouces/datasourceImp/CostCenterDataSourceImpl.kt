package br.com.celestial.apicore.resouces.datasourceImp

import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.resouces.adapter.toCostCenter
import br.com.celestial.apicore.resouces.adapter.toCostCenterDocument
import br.com.celestial.apicore.resouces.repository.centercost.CostCenterRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class CostCenterDataSourceImpl(
    private val repository: CostCenterRepository,
    private val mongoTemplate: MongoTemplate,
    //private val publisher: ApplicationEventPublisher,
): CostCenterDataSource {

    override fun findByName(name: String): CostCenter? =
        repository.findByName(name).map {
            it.toCostCenter()
        }.getOrNull()

    override fun existsByName(name: String): Boolean =
        repository.findByName(name).isPresent

    override fun save(t: CostCenter): CostCenter =
        repository.save(t.toCostCenterDocument()).toCostCenter()

    override fun delete(id: String) {
        repository.deleteById(id)
    }

    override fun findAll(): List<CostCenter> =
        repository.findAll().map { it.toCostCenter() }

    override fun findById(id: String): CostCenter? =
        repository.findById(id).map {
            it.toCostCenter()
        }.getOrNull()

}
