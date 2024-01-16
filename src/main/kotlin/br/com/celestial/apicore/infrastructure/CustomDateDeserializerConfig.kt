package br.com.celestial.apicore.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper

class CustomDateDeserializerConfig(
    val objectMapper: ObjectMapper
) {
    /*
    fun customDateModule(): Module =
        SimpleModule().apply {

            //addDeserializer(LocalDate::class.java, CustomLocalDateDeserializer())
            //addDeserializer(LocalDateTime::class.java, CustomLocalDateTimeDeserializer())

           // addSerializer(LocalDate::class.java, CustomLocalDateSerializer())
           // addSerializer(LocalDateTime::class.java, CustomLocalDateTimeSerializer())

            objectMapper.registerModule(this)
        }*/

}


