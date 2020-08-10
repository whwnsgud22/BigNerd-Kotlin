package chap9

import chap7.TAVERN_NAME_CHALLENGE
import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "Jun's Folly"
var playerGold = 10
var playerSilver = 10

//var patronList = listOf("Eli", "Mordoc", "Sophie")
val patronList: MutableList<String> = mutableListOf("Eli", "Mordoc", "Sophie")
val readOnlyPatronList = patronList.toList()

val menuList = File("data/tarvern-menu-items.txt")
        .readText()
        .split("\n")

val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatorns = mutableSetOf<String>()

fun main() {
//  println(patronList.getOrElse(5) {"Unknown Paton"})
//    val fifthPatron = patronList.getOrNull(4) ?: "Unknown Paton"
//    println(fifthPatron)

//    if(patronList.contains("Eli")) {
//        println("she is sleeping")
//    } else{
//        println("eli is not here")
//    }
//
//    if(patronList.containsAll(listOf("Mordoc" , "Sophie"))){
//        println("있습니다")
//    } else{
//        println("없습니다")
//    }


//    println(patronList)
//    patronList.add("jun")
//    patronList.add(2, "at")
//    patronList.remove("Eli")
//    patronList[0] = "Alexis"
//    for(patorn in patronList) {
//        println(patorn)
//    }

//    patronList.forEachIndexed{ index, patron ->
//        println("좋은 밤입니다. $patron #${index + 1 }")
//    }
//    menuList.forEach {
//        println(it)
//    }
//    val (type, _, price) = menuList[0].split(",")
//    println("$type , $price")

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatorns += name
    }
    println(uniquePatorns)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatorns.shuffled().first(),
                menuList.shuffled().first())
        orderCount++
    }
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPrice = playerGold + (playerSilver / 100.0)
    val remainingBalance = totalPrice - price
    println("전체 금액: $totalPrice")


//    println("금화 $price 로 술 구입")
//    println("남은 잔액: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSeilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSeilver

    displayBalance()
    println()
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: ${playerGold}, 은화: ${playerSilver}")
}

private fun displayNotBalance() {
    println("금화가 부족하여 살 수 없음")
    println()
}

private fun placeOrder(uniqueName: String, menu: String) {
    val indexOfApostrophe = TAVERN_NAME_CHALLENGE.indexOf('\'')
//    val tavernMaster = TAVERN_NAME_CHALLENGE.substring(0 until indexOfApostrophe)
//    println(tavernMaster)

    val (type, name1, price) = menu.split(',')
    val message = "$uniqueName 은 $price 로 $name1 ($type)을 구입."
    println(message)

//    performPurchase(price.toDouble())
//    performPurchase(price.toDouble())
//    performPurchase(price.toDouble())

    val phrase = if (name1 == "Dragon's Breath") {
        "$uniqueName 은 감탄: ${toDragonSpeak("$name1 좋구나")}"
    } else {
        "$uniqueName 감사합니다."
    }

    println(phrase)
    println("")
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

