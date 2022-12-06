class Day06 : AdventOfCode(7, 19) {
    private fun parse(input: List<String>, size: Int): Int {
        return input.sumOf {
            val result = it.withIndex().windowed(size, 1).map { it.distinctBy { it.value } }.firstOrNull { it.size == size }?.lastOrNull()?.index
                    ?: 0
            result + 1
        }
    }

    override fun part1(input: List<String>): Int {
        return parse(input, 4)
    }

    override fun part2(input: List<String>): Int {
        return parse(input, 14)
    }
}
