import First.Math2
import org.junit.Assert
import org.junit.Test

class Math2Test {

    @Test
    fun addTest() {
        val math = Math2()
        val expected = 3
        math.add(1, 2)
        val actual = math.result

        Assert.assertEquals(expected, actual)
    }
}