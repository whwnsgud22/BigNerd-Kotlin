package chap11

fun main() {
    val player = Player()
    player.castFireball(2)

    printPlayerStatus(player)
}


private fun printPlayerStatus(player: Player) {
    println("(Aura: $player.auraColor) +" +
            " (Blessed: ${if (player.isBlessed) "YES" else "NO"})")

    println("${player.name} ${player.formatHealthStatus()}")
}

