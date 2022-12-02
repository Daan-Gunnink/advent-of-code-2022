fun main() {
    fun calculateScoreFromMap(input: List<String>, map: Map<String, Int>): Int {
        var totalScore = 0

        input.forEach {
            totalScore += map[it] ?: 0
        }

        return totalScore
    }

    fun part1(input: List<String>): Int {
        return calculateScoreFromMap(
                input,
                mapOf(
                        Pair("A X", 4),
                        Pair("A Y", 8),
                        Pair("A Z", 3),
                        Pair("B X", 1),
                        Pair("B Y", 5),
                        Pair("B Z", 9),
                        Pair("C X", 7),
                        Pair("C Y", 2),
                        Pair("C Z", 6),
                )
        )
    }

    fun part2(input: List<String>): Int {
        return calculateScoreFromMap(
                input,
                mapOf(
                        Pair("A X", 3),
                        Pair("A Y", 4),
                        Pair("A Z", 8),
                        Pair("B X", 1),
                        Pair("B Y", 5),
                        Pair("B Z", 9),
                        Pair("C X", 2),
                        Pair("C Y", 6),
                        Pair("C Z", 7),
        ))
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
