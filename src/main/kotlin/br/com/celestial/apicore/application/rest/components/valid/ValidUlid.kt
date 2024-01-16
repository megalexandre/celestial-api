package br.com.celestial.apicore.application.rest.components.valid

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [UlidValidator::class])
annotation class ValidUlid(
    val message: String = "Invalid ULID",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)