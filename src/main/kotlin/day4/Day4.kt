package day4

import kotlin.math.pow

val lineRegex = Regex("""Card\s+\d+: (?<left>[\d\s]+) \| (?<right>[\d\s]+)""")

fun day4Part1(lines: Sequence<String>): Long {
    return lines.fold(0) { acc, line ->
        println("Line: $line")
        val matchResult = lineRegex.matchEntire(line)
        val leftSide = matchResult?.groups?.get("left")?.value?.split(" ")?.filter { it.isNotEmpty() }?.mapTo(HashSet()) { it.toInt() } ?: emptySet()
        val rightSide = matchResult?.groups?.get("right")?.value?.split(" ")?.filter { it.isNotEmpty() }?.mapTo(HashSet()) { it.toInt() } ?: emptySet()
        val matchingNumbers = leftSide.intersect(rightSide)
        println("Matching numbers: $matchingNumbers")
        val score = if (matchingNumbers.isNotEmpty()) 2.0.pow(matchingNumbers.size - 1).toLong() else 0
        println("Score: $score")
        if (matchingNumbers.isNotEmpty()) acc + 2.0.pow(matchingNumbers.size - 1).toLong() else acc
    }
}