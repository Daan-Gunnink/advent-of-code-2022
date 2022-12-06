abstract class AdventOfCode(testPart1: Any, testPart2: Any) {
    abstract fun part1(input: List<String>): Any

    abstract fun part2(input: List<String>): Any


    init {
        val currentDay = this::class.simpleName.toString()
        val testInput = readInput("${currentDay}_test")
        check(part1(testInput) == testPart1)
        check(part2(testInput) == testPart2)


        val input = readInput(currentDay)
        println("${currentDay}-1 - ${part1(input)}")
        println("${currentDay}-2 - ${part2(input)}")
        println()
    }
}
