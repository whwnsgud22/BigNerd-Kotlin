package chap13
import java.io.File

class Player(
        _name: String,
        var healthPoints: Int,
        val isBlessed: Boolean,
        private val isImmortal: Boolean
) {
    var name = _name
        get() = "$field.capitalize() of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown: String = selectHometown()

    init {
        require(healthPoints > 0, {"healthPoints는 0보다 커야 합니다."})
        require(name.isNotBlank(), {"플레이어는 이름이 있어야합니다."})
    }
    constructor(name: String) : this(name,
            healthPoints=100,
            isBlessed = true,
            isImmortal = false
    ){
        if(name.toLowerCase() == "kar") healthPoints = 40
    }

    private fun selectHometown() = File("data/towns")
            .readText()
            .split("\n")
            .shuffled()
            .first()
}