package br.com.celestial.apicore.domain.entity

import com.mongodb.assertions.Assertions.assertFalse
import com.mongodb.assertions.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DocumentNumberTest{

    @Test
    fun `when receiver wrong size digit should reject`(){
        listOf(
            "5485974503",
            "548597450355",
            "1130105400010",
            "113010540001031"
        ).forEach {
            assertFalse(DocumentNumber(it).isValid)
        }
    }

    @Test
    fun `when receiver an CPF with same digit should reject`(){
        listOf(
            "00000000000","11111111111","22222222222","33333333333","44444444444",
            "55555555555","66666666666","77777777777","88888888888","99999999999"
        ).forEach {
            assertFalse(DocumentNumber(it).isValid)
        }
    }

    @Test
    fun `when receiver an CNPJ with same digit should reject`(){
        listOf(
            "00000000000000", "11111111111111", "22222222222222", "33333333333333",
            "44444444444444", "55555555555555", "66666666666666", "77777777777777",
            "88888888888888", "99999999999999"
        ).forEach {
            assertFalse(DocumentNumber(it).isValid)
        }
    }

    @Test
    fun `when receiver an CPF invalid digit should reject`(){
        listOf(
            "13009120061","34231397043","86597718088","28114819065",
            "54440787089","89905293010","91926930060","64859745035"
        ).forEach {
            assertFalse(DocumentNumber(it).isValid)
        }
    }
    @Test
    fun `when receiver an CNPJ invalid digit should reject`(){
        listOf(
            "15964036000262","15674641000307","85647634000192","21640517000116",
            "43240073000173","94841503000180","12241033000103","73013983000175"
        ).forEach {
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

    @Test
    fun `when receiver valid CNPJ should accept`(){
        listOf(
            "58577114000189",
            "57407849000100",
            "34885583000105",
            "84220380000160",
            "22108412000182",
            "41384534000146",
            "41384534000146",
            "29992802000107",
            "70322244000176",
            "37745409000147",
            "63859681000168"
        ).forEach {
            assertTrue(DocumentNumber(it).isValid)
        }
    }

}