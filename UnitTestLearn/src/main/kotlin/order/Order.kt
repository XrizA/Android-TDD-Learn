package order

import umbrella.IWeather
import umbrella.Weather

class Order {

    fun insertOrder(email: String, quantity: Int, price: Int, emailUtil: IEmailUtil) {
        val weather: IWeather = Weather()
        val umbrella = Umbrella(weather)
        umbrella.totalPrice(quantity, price)

        // 新增訂單

        // 寄送mail給使用者
        emailUtil.sendCustomer(email)
    }

}