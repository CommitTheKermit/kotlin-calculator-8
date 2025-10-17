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

fun parseNumbers(expression: String, delimiters: List<String>): List<Int> {
    val numberStrings = expression.split(*delimiters.toTypedArray())

    return numberStrings.map { numberString ->
        when {
            numberString.isEmpty() -> 0
            numberString.toIntOrNull() == null ->
                throw IllegalArgumentException("[ERROR] 숫자가 아닌 문자: $numberString")
            numberString.toInt() < 0 ->
                throw IllegalArgumentException("[ERROR] 음수는 허용되지 않습니다: $numberString")
            else -> numberString.toInt()
        }
    }
}

fun calculate(numbers: List<Int>): Int {
    return numbers.sum()
}

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val delimiter = Delimiter(input)
    val numbers = parseNumbers(delimiter.expression, delimiter.delimiters)
    val result = calculate(numbers)

    println("결과 : $result")
}