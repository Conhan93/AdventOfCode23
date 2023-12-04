import day3.day3Part1
import day3.day3Part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `day 3 part 1 example`() {
        val exampleInput = sequenceOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
        )
        val result = day3Part1(exampleInput)
        assertEquals(4361, result)
    }

    @Test
    fun `day 3 part 1 with numbers at ends of the rows`() {
        val exampleInput = sequenceOf(
            "467..114..1",
            "...*......2",
            "..35..633.3",
            "......#...4",
            "617*......5",
            ".....+.58.6",
            "..592.....7",
            "......755.8",
            "...$.*....9",
            ".664.598...",
            ".........+.",
            "..........9"
        )
        val result = day3Part1(exampleInput)
        assertEquals(4370, result)
    }

    @Test
    fun `day 3 part 2 example`() {
        val exampleInput = sequenceOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
        )
        val result = day3Part2(exampleInput)
        assertEquals(467835, result)
    }
}