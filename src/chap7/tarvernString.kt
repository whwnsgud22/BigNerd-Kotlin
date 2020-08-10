package chap7

const val TAVERN_NAME = "Jun's Folly"

fun main() {
//    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
}

private fun placeOrder(menu: String){
    val indexOfApostrophe = TAVERN_NAME_CHALLENGE.indexOf('\'')
    val tavernMaster = TAVERN_NAME_CHALLENGE.substring(0 until indexOfApostrophe)
    println(tavernMaster)

//    val data = menu.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    val (type, name, price) = menu.split(',')
    val message = "$price 로 $name ($type)을 구입."

    println(message)

//    val phrase = "$name 좋구나"
//    println("감탄: ${toDragonSpeak(phrase)}")

    val phrase = if(name == "Dragon's Breath"){
        "감탄: ${toDragonSpeak("$name 좋구나")}"
    } else{
        "감사합니다. $name"
    }

    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[aeiou]")){
            when(it.value){
                "a" -> "4"
                "e" -> "3"
                "i" -> "1"
                "o" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }
