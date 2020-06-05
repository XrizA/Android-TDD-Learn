package io.github.xriza

import org.junit.Test
import org.mockito.Mockito.*

internal class RepositoryTest {

    @Test
    fun saveUserId() {

        val mockSharedPreferenceManager = mock(ISharedPreferenceManager::class.java)

        val userId = "A1234567"
        val preKey = "USER_ID"

        val repository = Repository(mockSharedPreferenceManager)
        repository.saveUserId(userId)

        verify(mockSharedPreferenceManager).saveString(preKey, userId)
    }
}