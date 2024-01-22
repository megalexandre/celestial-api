package br.com.celestial.apicore.application.rest.validator.documentNumber

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class DigitsOnlyConstraint : ConstraintValidator<DocumentNumberValidator, String> {

    override fun isValid(value: String, cxt: ConstraintValidatorContext): Boolean =
        value.matches(Regex("[0-9]+"))
}