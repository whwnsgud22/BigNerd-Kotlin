package chap6

import java.lang.Exception

fun main() {
    var swordsJuggling: Int? = null
    val check : Boolean = false
    val isJugglingProficient = (1..3).shuffled().last() == 3

    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling, check)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e.message.toString())
    }

    println("저글링 개수: $swordsJuggling")
}

fun proficiencyCheck(swordsJuggling: Int?, check: Boolean) {
//    swordsJuggling ?: throw IllegalStateException("예외가 발생해 처리할 수 없음")
//    swordsJuggling ?: throw UnskilledSwordJugglerException()
//    checkNotNull(swordsJuggling, {"예외 발생"})
//    error(swordsJuggling ?: throw UnskilledSwordJugglerException())
//    swordsJuggling ?: require(check)
//    requireNotNull(swordsJuggling)
    swordsJuggling ?: assert(check)
}

class UnskilledSwordJugglerException() : IllegalStateException("예외가 발생하여 처리할 수 없음")