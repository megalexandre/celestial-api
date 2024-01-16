package br.com.celestial.apicore.resouces.repository

import br.com.celestial.apicore.common.util.normalize
import br.com.celestial.apicore.domain.datasource.CostCenterDataSource
import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.resouces.adapter.toCostCenter
import br.com.celestial.apicore.resouces.adapter.toCostCenterDocument
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CenterCostRepositoryImpl(
    private val repository: CenterCostRepository,
    private val mongoTemplate: MongoTemplate,
    private val publisher: ApplicationEventPublisher,
): CostCenterDataSource {

    override fun findByName(name: String): CostCenter? =
        repository.findByNameNormalized(name.normalize()).map {
            it.toCostCenter()
        }.getOrNull()

    override fun existsByName(name: String): Boolean =
        repository.findByNameNormalized(name).isPresent

    override fun save(t: CostCenter): CostCenter =
        repository.save(t.toCostCenterDocument()).toCostCenter()

    override fun delete(id: String) {
        repository.deleteById(id)
    }

    override fun findAll(): List<CostCenter> =
        repository.findAll().map { it.toCostCenter() }

    override fun findById(id: String): CostCenter? =
        mongoTemplate.findById(id)

}