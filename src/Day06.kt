fun parse(input: List<String>, size: Int): Int {
    return input.sumOf {
        val result = it.withIndex().windowed(size, 1).map { it.distinctBy { it.value } }.firstOrNull { it.size == size }?.lastOrNull()?.index ?: 0
        result + 1
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        return parse(input, 4)
    }

    fun part2(input: List<String>): Int {
        return parse(input, 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)


    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
