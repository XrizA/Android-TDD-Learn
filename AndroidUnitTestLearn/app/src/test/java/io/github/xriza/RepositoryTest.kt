package io.github.xriza

import android.content.Context
import android.content.SharedPreferences
import org.junit.Test
import org.mockito.Mockito.*

internal class RepositoryTest {

    @Test
    fun saveUserId() {
        /*val sharedPrefs = mock(SharedPreferences::class.java)
        val sharedPrefsEditor = mock(SharedPreferences.Editor::class.java)
        val context = mock(Context::class.java)

        `when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs)
        `when`(sharedPrefs.edit()).thenReturn(sharedPrefsEditor)
        `when`(sharedPrefsEditor.putString(anyString(), anyString())).thenReturn(sharedPrefsEditor)*/

        val mockSharedPreferenceManager = mock(ISharedPreferenceManager::class.java)

        val userId = "A1234567"
        val preKey = "USER_ID"

        val repository = Repository(mockSharedPreferenceManager)
        repository.saveUserId(userId)

        /*verify(sharedPrefsEditor).putString(
            argThat { key -> key == preKey },
            argThat { value -> value == userId }
        )

        verify(sharedPrefsEditor).commit()*/
        verify(mockSharedPreferenceManager).saveString(preKey, userId)
    }
}