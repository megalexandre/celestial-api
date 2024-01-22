package br.com.celestial.apicore.application.rest.validator.documentNumber

import br.com.celestial.apicore.domain.entity.DocumentNumber
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class DocumentNumberConstraint : ConstraintValidator<DocumentNumberValidator, String> {

    override fun isValid(value: String, cxt: ConstraintValidatorContext): Boolean = DocumentNumber(value).isValid

}