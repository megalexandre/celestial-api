package br.com.celestial.apicore.domain.entity

data class PhoneNumber(
    val preferential: Boolean,
    val number: String,
    val isWhatApp: Boolean
)