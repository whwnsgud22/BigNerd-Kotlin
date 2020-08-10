package chap4

fun main() {
    val name = "마드리갈"
    val isBlessed = true
    val isImmortal = false
    val healthPoints = 50

    formatHealthStatus(healthPoints = 20, isBlessed = true)
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    printPlayerStatus(isBlessed, auraColor, healthPoints, name)
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
        when (healthPoints) {
            100 -> "최상의 상태"
            in 90..99 -> "약간의 찰과상"
            in 75..89 -> if (isBlessed) {
                "경미한 상터가 있지만 빨리 치유 중"
            } else {
                "경미한 상처만 있음"
            }
            in 15..74 -> "많이 다침"
            else -> "최악의 상태"
        }

private fun auraColor(isBlessed: Boolean, healthPoints: Int , isImmortal: Boolean , auraVisible: Boolean = isBlessed && healthPoints > 50 || isImmortal) =
        when (auraVisible) {
            true -> "GREEN"
            false -> "NONE"
        }

private fun printPlayerStatus(isBlessed: Boolean, auraColor: String, healthPoints: Int, name: String) {
    println("(Aura: $auraColor) +" +
            " (Blessed: ${if (isBlessed) "YES" else "NO"})")

    println("$name $healthPoints")
}

private fun castFireball(numFireballs: Int) =
        println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")