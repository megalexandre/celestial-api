package stubs.entity

import br.com.celestial.apicore.domain.entity.DocumentNumber
import br.com.celestial.apicore.domain.entity.User
import io.azam.ulidj.ULID.random
import java.time.LocalDate


val documentNumber =
    DocumentNumber(random())

val userStub = User(
    id = random(),
    name = "teste",
    documentNumber = documentNumber,
    birthDay = LocalDate.now(),
    phoneNumbers = null,
    active = true
)