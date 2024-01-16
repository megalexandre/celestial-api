package br.com.celestial.apicore.application.rest.components.valid

import io.azam.ulidj.ULID
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class UlidValidator : ConstraintValidator<ValidUlid, String> {

    override fun initialize(constraintAnnotation: ValidUlid) {}

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        return value?.let {
            try {
                ULID.isValid(value)
                true
            } catch (e: IllegalArgumentException) {
                false
            }
        } ?: true
    }
}