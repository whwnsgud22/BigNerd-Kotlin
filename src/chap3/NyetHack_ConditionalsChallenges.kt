package chap3

fun main(){
    val name = "마드리갈"
    val isBlessed = true
    val isImmortal = false
    val healthPoints = 60
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    val healStatus = when(healthPoints){
        100 -> "최상의 상태"
        in 90..99 -> "약간의 찰과상"
        in 75 ..89 -> if(isBlessed) {
            "경미한 상터가 있지만 빨리 치유 중"
        } else{
            "경미한 상처만 있음"
        }
        in 15..74 -> "많이 다침"
        else -> "최악의 상태"
    }
    val function = when(auraVisible){
        true -> when(karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            in 16..20 -> "green"
            else -> "범위를 벗어남"
        }
        else -> "오류"
    }

    println(function)
    println("(Aura: $auraVisible) +" +
            " (Blessed: ${if(isBlessed) "YES" else "NO"})")
    println("$name $healthPoints")

    val statusFormatString = "(HP)(A) -> H"

    }