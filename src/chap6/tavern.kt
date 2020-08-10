package chap6

fun main() {
//    var beverage = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "값이 안들어갔을때~"
//        }
//    }
//    var beverage = readLine()?.capitalize()?.plus(" , large")
//    beverage = null
//    println(beverage)
    var beverage = readLine()

//    if(beverage != null) {
//        beverage = beverage.capitalize()
//    }else{
//        println("null 입니다")
//    }
//

    beverage?.let {
        beverage = it.capitalize()
    } ?: println("맥주")
    println(beverage)

//    val beverageServed: String = beverage ?: "맥주"
//    println(beverageServed)
}
