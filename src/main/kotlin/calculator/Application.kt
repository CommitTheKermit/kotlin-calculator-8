package calculator

import camp.nextstep.edu.missionutils.Console

class Delimiter(val input: String) {
    private val defaultDelimiter: List<String> = listOf(",", ":")

    val delimiters: List<String>

    init {
        delimiters = defaultDelimiter
    }
}

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val delimiter = Delimiter(input)
    val result = 0
    println("결과 : $result")
}