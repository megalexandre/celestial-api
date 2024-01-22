package br.com.celestial.apicore.resouces.datasourceImp

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.DocumentNumber
import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.resouces.adapter.user.toUser
import br.com.celestial.apicore.resouces.adapter.user.toUserDocument
import br.com.celestial.apicore.resouces.repository.user.UserRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class UserDataSourceImpl(
    private val repository: UserRepository,
    //private val mongoTemplate: MongoTemplate,
    //private val publisher: ApplicationEventPublisher,
): UserDataSource {
    override fun findByDocument(documentNumber: DocumentNumber): User? =
        repository.findByDocumentNumber(documentNumber.number)?.toUser()

    override fun save(t: User): User =
        repository.save(t.toUserDocument()).toUser()

    override fun delete(id: String) {
        repository.deleteById(id)
    }

    override fun findAll(): List<User> = repository.findAll().map { it.toUser() }

    override fun findById(id: String): User? = repository.findById(id).map { it.toUser() }.getOrNull()

}