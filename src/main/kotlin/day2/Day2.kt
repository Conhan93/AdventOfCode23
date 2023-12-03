package day2

import java.util.*

enum class Colour { RED, GREEN, BLUE }

fun day2Part1(lines: Sequence<String>): Int {
    val maxColourValues = mapOf(Colour.RED to 12, Colour.GREEN to 13, Colour.BLUE to 14)

    return lines.fold(0) { acc, line ->
        val colourValuesByColour = getColourValuesByColour(line)
        val valuesOverThresholdByColour = colourValuesByColour.filter { (colour, values) -> (values.maxOrNull() ?: 0) > (maxColourValues[colour]!!) }
        if (valuesOverThresholdByColour.values.any { it.isNotEmpty() }) acc else acc + getGameNumber(line)
    }.also { println("sum: $it") }
}

fun day2Part2(lines: Sequence<String>) = lines.fold(0L) { acc, line -> acc + getColourValuesByColour(line).values.map { it.max().toLong() }.reduce(Long::times) }.also { println("sum: $it") }

val gameNumberRegex = Regex("Game (\\d+):")
fun getGameNumber(line: String): Int = gameNumberRegex.find(line)?.groupValues?.get(1)?.toInt().also { println("game number $it") } ?: throw IllegalArgumentException("Invalid line: $line")

fun getColourValuesByColour(line: String): Map<Colour, List<Int>> {
    val valuesByColour = mutableMapOf<Colour, MutableList<Int>>(Colour.RED to mutableListOf(), Colour.GREEN to mutableListOf(), Colour.BLUE to mutableListOf())
    Colour.entries.forEach { colour ->
        val valuesForColour = Regex("(\\d+) ${colour.name.lowercase(Locale.getDefault())}").findAll(line).map { it.groupValues[1].toInt() }.toList()
        println("values for colour $colour: $valuesForColour at line $line")
        valuesByColour[colour]?.addAll(valuesForColour)
    }
    return valuesByColour
}