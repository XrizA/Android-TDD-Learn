package io.github.xriza

import android.os.Build
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowAlertDialog

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class MainActivityTest {

    private lateinit var activity: MainActivity

    @Before
    fun setupActivity() {
        MockitoAnnotations.initMocks(this)

        activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun registerSuccessShouldDirectToResult() {
        val shadowActivity = Shadows.shadowOf(activity)

        val userId = "A123456789"
        val userPassword = "a123456789"

        activity.loginId.setText(userId)
        activity.password.setText(userPassword)

        activity.send.performClick()

        val nextIntent = shadowActivity.nextStartedActivity
        assertEquals(nextIntent.component!!.className, ResultActivity::class.java.name)
        assertEquals(1, nextIntent.extras!!.size())
        assertEquals(userId, nextIntent.extras!!.getString("ID"))
    }

    @Test
    fun registerFailShouldAlert() {
        val userId = "A1234"
        val userPassword = "a123456789"

        activity.loginId.setText(userId)
        activity.password.setText(userPassword)

        activity.send.performClick()

        val dialog = ShadowAlertDialog.getLatestDialog()

        assertNotNull(dialog)
        assertTrue(dialog.isShowing)
    }
}