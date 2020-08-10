package chap7

const val TAVERN_NAME_CHALLENGE = "Jun's Folly"

fun main() {
    placeOrder("DRAGON'S, BREATH: IT'S GOT WHAT ADVENTURES CRAVE!")
}

private fun placeOrder(menu: String) {
    val name = menu

    val phrase = if (name == "DRAGON'S, BREATH: IT'S GOT WHAT ADVENTURES CRAVE!") {
        "감탄: ${toDragonSpeak("$name 좋구나")}"
    } else {
        "감사합니다. $name"
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[aeiouAEIOU]")) {
            when (it.value) {
                "a", "A" -> "4"
                "e", "E" -> "3"
                "i", "I" -> "1"
                "o", "O" -> "0"
                "u", "U" -> "|_|"
                else -> it.value
            }
        }

