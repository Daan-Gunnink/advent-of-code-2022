class Day06 : AdventOfCode(7, 19) {
    private fun parse(input: List<String>, size: Int): Int {
        return input.first().windowed(size).indexOfFirst { it.toSet().size == size } + size
    }

    override fun part1(input: List<String>): Int {
        return parse(input, 4)
    }

    override fun part2(input: List<String>): Int {
        return parse(input, 14)
    }
}
