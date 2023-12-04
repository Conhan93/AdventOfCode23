package day3



fun isSymbol(character: Char) = !character.isDigit() && character != '.'

fun numbersFromLine(line: String): List<Pair<Int, ClosedRange<Int>>> {
    val numbers = mutableListOf<Pair<Int, ClosedRange<Int>>>()
    var currentNumber = 0
    var currentRangeStart = 0
    var currentRangeEnd: Int

    var creatingNumber = false


    line.forEachIndexed { index, character ->
        if (character.isDigit() && !creatingNumber) {
            creatingNumber = true
            currentRangeStart = index
            currentNumber = character.toString().toInt()
            if (index == line.length - 1) {
                currentRangeEnd = index
                numbers.add(currentNumber to currentRangeStart..currentRangeEnd)
            }
        } else if (character.isDigit() && creatingNumber) {
            currentNumber = currentNumber * 10 + character.toString().toInt()
            if (index == line.length - 1) {
                currentRangeEnd = index
                numbers.add(currentNumber to currentRangeStart..currentRangeEnd)
            }
        } else if (!character.isDigit() && creatingNumber) {
            creatingNumber = false
            currentRangeEnd = index - 1
            numbers.add(currentNumber to currentRangeStart..currentRangeEnd)
            currentNumber = 0
        }
    }
    return numbers
}

fun findAdjacentNumbers(symbolIndex: Int, numberLines : List<List<Pair<Int, ClosedRange<Int>>>>): List<Int> {
    return numberLines
        .flatten()
        .filter { (_, range) -> rangeIsAdjacentToSymbol(range, symbolIndex) }
        .map { it.first }
}

fun rangeIsAdjacentToSymbol(range: ClosedRange<Int>, symbolIndex: Int): Boolean {
    return range.contains(symbolIndex - 1) || range.contains(symbolIndex) || range.contains(symbolIndex + 1)
}

fun day3Part1(lines: Sequence<String>): Long {
    return lines.windowed(3) { (topLine, middleLine, bottomLine) ->
        val symbolIndices = middleLine.mapIndexedNotNull { index, character -> if (isSymbol(character)) index else null }.toIntArray()
        val topLineNumbers = numbersFromLine(topLine)
        val middleLineNumbers = numbersFromLine(middleLine)
        val bottomLineNumbers = numbersFromLine(bottomLine)
        println()
        println("For line: $middleLine")
        println("topLineNumbers: $topLineNumbers")
        println("middleLineNumbers: $middleLineNumbers")
        println("bottomLineNumbers: $bottomLineNumbers")
        println("symbolIndices: ${symbolIndices.toList()}")
        val adjacentNumbers = symbolIndices.flatMap { findAdjacentNumbers(it, listOf(topLineNumbers, middleLineNumbers, bottomLineNumbers)) }
        println("adjacentNumbers: $adjacentNumbers")
        adjacentNumbers.sum().toLong()
    }.sum()
}

fun day3Part2(lines: Sequence<String>): Long {
    return lines.windowed(3) { (topLine, middleLine, bottomLine) ->
        val symbolIndices = middleLine.mapIndexedNotNull { index, character -> if (character == '*') index else null }.toIntArray()
        val topLineNumbers = numbersFromLine(topLine)
        val middleLineNumbers = numbersFromLine(middleLine)
        val bottomLineNumbers = numbersFromLine(bottomLine)
        println()
        println("For line: $middleLine")
        println("topLineNumbers: $topLineNumbers")
        println("middleLineNumbers: $middleLineNumbers")
        println("bottomLineNumbers: $bottomLineNumbers")
        println("symbolIndices: ${symbolIndices.toList()}")
        symbolIndices.map { gearIndex ->
            val partNumbersAdjacentToGear = findAdjacentNumbers(gearIndex, listOf(topLineNumbers, middleLineNumbers, bottomLineNumbers))
            if (partNumbersAdjacentToGear.size == 2) partNumbersAdjacentToGear.map { it.toLong() }.reduce(Long::times) else null
        }
    }.flatten().filterNotNull().sum()
}