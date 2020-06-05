import org.junit.Assert
import org.junit.Test
import order.Umbrella
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import umbrella.IWeather
import umbrella.Weather

class UmbrellaTest {

    @Test
    fun totalPrice_sunnyDay() {
        val umbrella = Umbrella(Weather())

        val weather = StubWeather()

        weather.fakeIsSunny = true

        val  actual = umbrella.totalPrice(weather, 3, 100)
        val  expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay() {
        val umbrella = Umbrella(Weather())

        val weather = StubWeather()

        weather.fakeIsSunny = false

        val actual = umbrella.totalPrice(weather, 3, 100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_sunnyDay_constructorInjection() {
        val weather = StubWeather()

        val umbrella = Umbrella(weather)

        weather.fakeIsSunny = true

        val actual = umbrella.totalPrice(3, 100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay_constructorInjection() {
        val weather = StubWeather()

        val umbrella = Umbrella(weather)

        weather.fakeIsSunny = false

        val actual = umbrella.totalPrice(3, 100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_sunnyDay_mockito() {
        val weather = mock(IWeather::class.java)

        val umbrella = Umbrella(weather)

        `when`(weather.isSunny()).thenReturn(true)

        val actual = umbrella.totalPrice(3, 100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay_mockito() {
        val weather = mock(IWeather::class.java)

        val umbrella = Umbrella(weather)

        `when`(weather.isSunny()).thenReturn(false)

        val actual = umbrella.totalPrice(3, 100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }
}