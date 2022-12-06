class Day01 : AdventOfCode(24000, 45000) {
    override fun part1(input: List<String>): Int {
        val result = input.splitAfter("").map {
            it.filter { it.isNotEmpty() }.sumOf { it.toInt() }
        }
        return result.maxOf { it }
    }
    override fun part2(input: List<String>): Int {
        val result = input.splitAfter("").map {
            it.filter { it.isNotEmpty() }.sumOf { it.toInt() }
        }
        return result.sortedDescending().take(3).sum()
    }
}
