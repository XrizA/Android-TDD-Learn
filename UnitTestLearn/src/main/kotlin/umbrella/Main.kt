package umbrella

import order.Umbrella

fun main() {
    val weather: IWeather = Weather()
    val umbrella = Umbrella(weather)
    umbrella.totalPrice(weather, 1, 600)
}

fun mainConstructorInjection() {
    val weather: IWeather = Weather()
    val umbrella = Umbrella(weather)
    umbrella.totalPrice(1, 600)
}