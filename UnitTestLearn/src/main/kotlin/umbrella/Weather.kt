package umbrella

class Weather : IWeather {
    override fun isSunny(): Boolean {
        return true
    }
}