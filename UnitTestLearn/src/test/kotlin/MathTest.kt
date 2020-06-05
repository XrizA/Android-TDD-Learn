import First.Math
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MathTest {
    lateinit var math: Math

    @Before
    fun setUp() {
        math = Math()
    }

    @Test
    fun addTest() {
        val expected = 3
        val actual = math.add(1, 2)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun Number1LessNumber2Test() {
        val expected = math.minimum(1, 3)
        val actual = 1
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun Number2LessNumber1Test() {
        val expected = math.minimum(3, 1)
        val actual = 1
        Assert.assertEquals(expected, actual)
    }
}