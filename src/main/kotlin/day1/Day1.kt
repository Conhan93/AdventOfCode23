package day1


fun day1Part1(lines: Sequence<String>) = lines.fold(0) { acc, line -> acc + line.filter { it.isDigit() }.let { ("${it.first()}${it.last()}").toInt() } }


fun day1Part2(lines: Sequence<String>): Long {
    val digits = mapOf("one" to "1", "two" to "2", "three" to "3", "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9")
    val numberRegex = Regex("[0-9]|one|two|three|four|five|six|seven|eight|nine")
    var sum = 0L
    lines.forEach { line ->
        val lineMatches = numberRegex.findAll(line).mapNotNull { it.value.toIntOrNull() ?: digits[it.value]?.toInt() }.toList().toIntArray()
        if (lineMatches.isNotEmpty()) {
            sum += if (lineMatches.size == 1) lineMatches.first() else "${lineMatches.first()}${lineMatches.last()}".toInt()
        }
    }
    println("sum: $sum")
    return sum
}

