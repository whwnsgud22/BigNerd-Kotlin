package chap5

fun main() {
//    runSimulation("조준형", ::printConstructionCost) { playerName, numBuildings ->
//        val currentYear: Int = 2020
//        "방문을 환영합니다. $playerName 님. 건물 개수는 $numBuildings ($currentYear)"
//    }
    runSimulation()
}

//inline fun runSimulation(playerName: String, costPrinter: (Int) -> Unit, greetingFunction: (String, Int) -> String) {
//    val numBuildings = (1..3).shuffled().last() //1,2,3 중 무작위로 선택.
//    costPrinter(numBuildings)
//    println(greetingFunction(playerName, numBuildings))
//}

fun runSimulation(){
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("조준형"))
}

//fun printConstructionCost(numBuildings: Int){
//    val cost = 300
//    println("건축 비용: ${cost * numBuildings}")
//}

fun configureGreetingFunction(): (String) -> String{
    val structureType = "병원"
    var numBuildings = 12
    return {
        playerName: String ->
        val currentYear = 2020
        numBuildings += 1
        println("$numBuildings 채의 $structureType 추가됨" )
        "방문을 환영합니다. $playerName 님. 건물 개수는 $numBuildings ($currentYear)"
    }
}