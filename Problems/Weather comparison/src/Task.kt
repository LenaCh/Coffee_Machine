class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value < -92 || value > 57) average1 else value

        }
    val average1 = getAverage(name)
    fun getAverage(name: String): Int {
        var average = 0
        when {
            name == "Dubai" -> average = 30
            name == "Moscow" -> average = 5
            name == "Hanoi" -> average = 20
        }
        return average
    }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    if (first == second || second == third || third == first) {
        println("neither")
    } else if (minOf(firstCity.degrees, secondCity.degrees, thirdCity.degrees) == secondCity.degrees) {
        print("Moscow")
    } else if (minOf(firstCity.degrees, secondCity.degrees, thirdCity.degrees) == firstCity.degrees) {
        print("Dubai")
    } else if (minOf(firstCity.degrees, secondCity.degrees, thirdCity.degrees) == thirdCity.degrees) {
        print("Hanoi")
    }
}