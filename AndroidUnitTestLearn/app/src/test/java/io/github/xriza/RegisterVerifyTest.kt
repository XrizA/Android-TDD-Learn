package io.github.xriza

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class RegisterVerifyTest {
    lateinit var registerVerity: RegisterVerity

    @Before
    fun setUp() {
        registerVerity = RegisterVerity()
    }

    @Test
    fun isLoginIdVerifyTrue() {
        assertTrue(registerVerity.isLoginIdVerify("A123456"))
    }

    @Test
    fun loginVerifyFalse() {
        assertFalse(registerVerity.isLoginIdVerify("A1234"))
    }
}