package etc

fun main() {
    order("beer, cass, 3000")
}

private fun replacement(str: String) =
        str.replace(Regex("[es0]")){
            when(it.value){
                "e" -> "s"
                "s" -> "0"
                "0" -> "a"
                else -> it.value
            }
        }

private fun order(menu: String){
    println(menu)
    println(replacement(menu))
}