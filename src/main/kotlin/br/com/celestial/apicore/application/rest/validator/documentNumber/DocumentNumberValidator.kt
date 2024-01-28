package br.com.celestial.apicore.application.rest.validator.documentNumber

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.reflect.KClass

@Target(FIELD, FUNCTION)
@Retention(RUNTIME)
@Constraint(validatedBy = [DigitsOnlyConstraint::class, DocumentNumberConstraint::class])
@MustBeDocumented
annotation class DocumentNumberValidator(
    val message: String = "{}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)