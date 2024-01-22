package br.com.celestial.apicore.domain.entity

import com.mongodb.assertions.Assertions.assertFalse
import com.mongodb.assertions.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DocumentNumberTest{

    @Test
    fun `when receiver same digit should reject`(){
        val invalid = listOf(
            "00000000000","11111111111","22222222222","33333333333","44444444444",
            "55555555555","66666666666","77777777777","88888888888","99999999999"
        )

        invalid.forEach {
            assertFalse(DocumentNumber(it).isValid)
        }
    }

    @Test
    fun `when receiver valid CPF should accept`(){
        listOf(
            "13009120060","34281397043","85597718088","18114819065",
            "54440787088","89905293019","90926930060","54859745035"
        ).forEach {
            assertTrue(DocumentNumber(it).isValid)
        }
    }





}