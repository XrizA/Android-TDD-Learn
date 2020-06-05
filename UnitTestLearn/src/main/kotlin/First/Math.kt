package First

class Math {
    fun add(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    fun minimum(number1: Int, number2: Int): Int {
        return if (number1 > number2) number1 else number2
    }
}