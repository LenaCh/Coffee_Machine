package machine

import java.util.*

enum class Coffe(var water: Int, var milk: Int, var beans: Int, var money: Int, var cups: Int) {
    DEFOLT(400, 540, 120, 550, 9),
    FILL(0, 0, 0, 0, 0),
    ESPRESSO(250, 0, 16, 4, 1),
    LATTE(350, 75, 20, 7, 1),
    CAPPUCCINO(200, 100, 12, 6, 1);

    companion object {
        fun coffeMashineHas() {
            println("The coffee machine has:")
            println("${DEFOLT.water} of water")
            println("${DEFOLT.milk} of milk")
            println("${DEFOLT.beans} of coffee beans")
            println("${DEFOLT.cups} of disposable cups")
            println("${DEFOLT.money} of money")
        }
    }

    fun calculateRemain(action: String, resultcoffe: String) {
        if (action == "buy") {
            if (DEFOLT.water - valueOf(resultcoffe).water < 0 || DEFOLT.milk - valueOf(resultcoffe).milk < 0 || DEFOLT.beans - valueOf(resultcoffe).beans < 0 || DEFOLT.cups - valueOf(resultcoffe).cups < 0) {
                println("Sorry, not enough water!")
            } else {
                println("I have enough resources, making you a coffee!")
                DEFOLT.water = DEFOLT.water - valueOf(resultcoffe).water
                DEFOLT.milk = DEFOLT.milk - valueOf(resultcoffe).milk
                DEFOLT.beans = DEFOLT.beans - valueOf(resultcoffe).beans
                DEFOLT.cups = DEFOLT.cups - valueOf(resultcoffe).cups
                DEFOLT.money = DEFOLT.money + valueOf(resultcoffe).money
            }
        } else if (action == "take") {
            println("I gave you ${DEFOLT.money}")
            DEFOLT.money = 0
        } else if (action == "fill") {
            val scanner = Scanner(System.`in`)
            println("Write how many ml of water do you want to add: > ")
            val inWater = scanner.nextInt()
            println("Write how many ml of milk do you want to add: > ")
            val inMilk = scanner.nextInt()
            println("Write how many grams of coffee beans do you want to add: >")
            val inBeans = scanner.nextInt()
            println("Write how many disposable cups of coffee do you want to add: >")
            val incups = scanner.nextInt()
            DEFOLT.water = DEFOLT.water + inWater
            DEFOLT.milk = DEFOLT.milk + inMilk
            DEFOLT.beans = DEFOLT.beans + inBeans
            DEFOLT.cups = DEFOLT.cups + incups
        }
    }


}

fun main() {
    val scanner = Scanner(System.`in`)
    start@ do {
        println("Write action (buy, fill, take, remaining, exit): > ")
        val action = scanner.next()
        if (action == "exit") {
            break
        } else if (action == "remaining") {
            Coffe.coffeMashineHas()
        } else if (action == "buy") {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: > 3")
            val inputCoffeType = scanner.next()
            if (inputCoffeType.equals("back")) {
              continue@start
            } else {
                val coffeType = arrayOf("", "ESPRESSO", "LATTE", "CAPPUCCINO")
                val resultcoffe = Coffe.valueOf(coffeType[inputCoffeType.toInt()])
                resultcoffe.calculateRemain(action, coffeType[inputCoffeType.toInt()])
            }
        } else if (action == "fill") {
            val resultcoffe = Coffe.DEFOLT
            resultcoffe.calculateRemain(action, " ")
        } else if (action == "take") {
            val resultcoffe = Coffe.DEFOLT
            resultcoffe.calculateRemain(action, " ")

        }
    } while (action !== "exit")
}


