class Day02 : AdventOfCode(15, 12) {
    private fun calculateScoreFromMap(input: List<String>, map: Map<String, Int>): Int {
        var totalScore = 0

        input.forEach {
            totalScore += map[it] ?: 0
        }

        return totalScore
    }

    override fun part1(input: List<String>): Int {
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

    override fun part2(input: List<String>): Int {
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
}
