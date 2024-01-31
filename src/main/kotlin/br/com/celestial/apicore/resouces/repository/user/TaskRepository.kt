package br.com.celestial.apicore.resouces.repository.user

import br.com.celestial.apicore.resouces.document.TaskDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository : MongoRepository<TaskDocument, String>