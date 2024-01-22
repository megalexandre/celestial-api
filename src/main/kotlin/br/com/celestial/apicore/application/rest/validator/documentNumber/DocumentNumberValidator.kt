package br.com.celestial.apicore.application.rest.validator.documentNumber

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [
    DigitsOnlyConstraint::class

])
@MustBeDocumented
annotation class DocumentNumberValidator(
    val message: String = "{}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)