package br.com.celestial.apicore.infrastructure

import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature.NullIsSameAsDefault
import com.fasterxml.jackson.module.kotlin.KotlinFeature.NullToEmptyCollection
import com.fasterxml.jackson.module.kotlin.KotlinFeature.NullToEmptyMap
import com.fasterxml.jackson.module.kotlin.KotlinFeature.SingletonSupport
import com.fasterxml.jackson.module.kotlin.KotlinFeature.StrictNullChecks
import com.fasterxml.jackson.module.kotlin.KotlinModule.Builder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConfig{

    @Bean
    fun objectMapper(): ObjectMapper = ObjectMapper()
        .disable(FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(FAIL_ON_EMPTY_BEANS)
        .setSerializationInclusion(NON_NULL)
        .registerModule(JavaTimeModule())
        .registerModule(
            Builder()
                .withReflectionCacheSize(512)
                .configure(NullToEmptyCollection, false)
                .configure(NullToEmptyMap, false)
                .configure(NullIsSameAsDefault, false)
                .configure(SingletonSupport, false)
                .configure(StrictNullChecks, false)
            .build()
        )

    /*
     @Bean
    fun objectMapper(): ObjectMapper = ObjectMapper()
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

        .registerModule(JavaTimeModule())
        .registerModule(
            Builder()
                .withReflectionCacheSize(512)
                .configure(nullToEmptyCollection, false)
                .configure(nullToEmptyMap, false)
                .configure(nullIsSameAsDefault, false)
                .configure(singletonSupport, false)
                .configure(strictNullChecks, false)
                .build()
        )
    * */

}

