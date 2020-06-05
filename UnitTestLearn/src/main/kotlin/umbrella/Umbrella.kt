package umbrella

import umbrella.IWeather

class Umbrella(private val weather: IWeather) {

    fun totalPrice(quantity: Int, price: Int): Int {
        return totalPrice(this.weather, quantity, price)
    }

    fun totalPrice(weather: IWeather, quantity: Int, price: Int): Int {

        val isSunny = weather.isSunny()

        var price = quantity * price

        if (isSunny) {
            // 晴天 -> 打9折
            price = (price * 0.9).toInt()
        }

        return price
    }
}