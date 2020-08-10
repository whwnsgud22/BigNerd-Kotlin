package chap8

import chap7.TAVERN_NAME_CHALLENGE
import kotlin.math.roundToInt

const val TAVERN_NAME = "Jun's Folly"
var playerGold = 10
var playerSilver = 10

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPrice = playerGold + (playerSilver / 100.0)
    val remainingBalance = totalPrice - price
    println("전체 금액: $totalPrice")

    if(totalPrice <= price){
        displayNotBalance()
    } else{
        println("금화 $price 로 술 구입")
        println("남은 잔액: ${"%.2f".format(remainingBalance)}")

        val remainingGold = remainingBalance.toInt()
        val remainingSeilver = (remainingBalance % 1 * 100).roundToInt()
        playerGold = remainingGold
        playerSilver = remainingSeilver

        displayBalance()
        println()
    }
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold, 은화: $playerSilver")
}

private fun displayNotBalance(){
    println("금화가 부족하여 살 수 없음")
    println()
}

private fun placeOrder(menu: String) {
    val indexOfApostrophe = TAVERN_NAME_CHALLENGE.indexOf('\'')
    val tavernMaster = TAVERN_NAME_CHALLENGE.substring(0 until indexOfApostrophe)
    println(tavernMaster)

    val (type, name, price) = menu.split(',')
    val message = "$price 로 $name ($type)을 구입."
    println(message)

    performPurchase(price.toDouble())
    performPurchase(price.toDouble())
    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "감탄: ${toDragonSpeak("$name 좋구나")}"
    } else {
        "감사합니다. $name"
    }

    println(phrase)
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
