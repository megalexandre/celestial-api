package br.com.celestial.apicore.resouces.repository.user

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.DocumentNumber
import br.com.celestial.apicore.domain.entity.User
import org.springframework.stereotype.Service

@Service
class UserRepositoryImpl(
    //private val repository: UserRepository,
    //private val mongoTemplate: MongoTemplate,
    //private val publisher: ApplicationEventPublisher,
): UserDataSource {
    override fun findByDocument(documentNumber: DocumentNumber): User? {
        TODO("Not yet implemented")
    }

    override fun save(t: User): User {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): User? {
        TODO("Not yet implemented")
    }

}