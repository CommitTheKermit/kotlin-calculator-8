package calculator

import camp.nextstep.edu.missionutils.Console

class Delimiter(val input: String) {
    private val defaultDelimiter: List<String> = listOf(",", ":")

    val delimiters: List<String>
    val expression: String

    init {
        delimiters = defaultDelimiter + findCustomDelimiter()
        if (delimiters.size > 2) {
            expression = input.substring(4 + delimiters.last().length)
        } else {
            expression = input
        }
    }

    fun findCustomDelimiter(): List<String> {
        val matchResult: MatchResult? = Regex("//(.)\\\\n(.*)").find(input)
        if (matchResult != null && matchResult.groups[1] != null) {
            return listOf(matchResult.groups[1]!!.value)
        }

        return listOf()
    }
}

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val delimiter = Delimiter(input)
    val result = 0
    println("결과 : $result")
}