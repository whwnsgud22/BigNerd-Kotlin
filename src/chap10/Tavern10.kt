package chap10

import chap7.TAVERN_NAME_CHALLENGE
import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "Jun's Folly"

val patronList: MutableList<String> = mutableListOf("Eli", "Mordoc", "Sophie")
val readOnlyPatronList = patronList.toList()

val menuList = File("data/tarvern-menu-items.txt")
        .readText()
        .split("\n")

val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatorns = mutableSetOf<String>()
val patronGold = mutableMapOf<String, Double>()

fun main() {

    val (type, _, price) = menuList[0].split(",")
    println("$type , $price")

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatorns += name
    }

    uniquePatorns.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatorns.shuffled().first(),
                menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalances()
}

private fun performPurchase(price: Double, patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun placeOrder(uniqueName: String, menu: String) {
    val (type, name1, price) = menu.split(',')
    val message = "$uniqueName 은 $price 로 $name1 ($type)을 구입."
    println(message)

    performPurchase(price.toDouble(), uniqueName)

    val phrase = if (name1 == "Dragon's Breath") {
        "$uniqueName 은 감탄: ${toDragonSpeak("$name1 좋구나")}"
    } else {
        "$uniqueName 감사합니다."
    }

    println(phrase)
    println("")
}

private fun displayPatronBalances(){
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
     }
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[aeiou]")) {
            when (it.value) {
                "a" -> "4"
                "e" -> "3"
                "i" -> "1"
                "o" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }

