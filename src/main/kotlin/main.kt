import day1.day1Part1
import day1.day1Part2
import day2.day2Part1
import day2.day2Part2
import util.runChallenge


fun main() {
    runChallenge("day1.txt", ::day1Part1).also { println("challenge 1, part 1 answer: $it") }
    runChallenge("day1.txt", ::day1Part2).also { println("challenge 1, part 2 answer: $it") } // 52849 - too low
    runChallenge("day2.txt", ::day2Part1).also { println("challenge 2, part 1 answer: $it") }
    runChallenge("day2.txt", ::day2Part2).also { println("challenge 2, part 2 answer: $it") }
}