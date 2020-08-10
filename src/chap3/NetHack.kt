package chap3

fun main() {
    val name = "조준형"
    val healthPoints = 100
    val isBlessed = true

    val healthStatus = if(healthPoints == 100) {
        "최상의 상태"
    } else if(healthPoints >= 90){
        "약간의 찰과상"
    } else if(healthPoints >= 75){
        if(isBlessed){
            "경미한 상처 치료 가능"
        } else{
            "경미 상처"
        }
    } else if(healthPoints >= 15){
        "죽기 직전"
    } else{
        "죽음"
    }

    println(name + " " + healthStatus)
}