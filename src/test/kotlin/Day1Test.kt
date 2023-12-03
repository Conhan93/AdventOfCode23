import day1.day1Part1
import day1.day1Part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `part 1 example`() {
        val exampleInput = sequenceOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        )
        val result = day1Part1(exampleInput)
        assertEquals(142, result)
    }

    @Test
    fun `part 2 example`() {
        val exampleInput = sequenceOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        )
        val result = day1Part2(exampleInput)
        assertEquals(281, result)
    }
}