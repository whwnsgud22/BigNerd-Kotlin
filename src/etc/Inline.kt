package etc

fun main() {
    val result = newMethod(3, {println("Test")}, {println("인라인 함수는 참조하지 못한다.")})
}

fun inlineTest(a: Int, func: () -> Unit): Int{
    func()
    return 10*a
}

inline fun newMethod(a: Int, func: () -> Unit, noinline fun2: () -> Unit){
    func()
    inlineTest(3, fun2)
}

