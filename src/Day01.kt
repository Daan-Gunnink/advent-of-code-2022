fun main() {
    fun part1(input: List<String>): Int {
        val result = input.splitAfter("").map {
            it.filter { it.isNotEmpty() }.sumOf { it.toInt() }
        }
        return result.maxOf { it }
    }

    fun part2(input: List<String>): Int {
        val result = input.splitAfter("").map {
            it.filter { it.isNotEmpty() }.sumOf { it.toInt() }
        }
        return result.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
