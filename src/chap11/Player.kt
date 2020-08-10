package chap11

class Player {
    var name = "조준형"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    val isBlessed = true
    private val isImmortal = false
    val healthPoints = 50

    fun formatHealthStatus() =
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

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun castFireball(numFireballs: Int) =
            println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")


}
