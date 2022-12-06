class Day05 : AdventOfCode("CMZ", "MCD") {

    internal data class Move(
            val amount: Int,
            val fromColumn: Int,
            val toColumn: Int
    )

    private fun parseBoxes(input: List<String>): MutableList<MutableList<String>> {
        return input.map { it.withIndex().filter { it.value.isLetter() } }.flatten().sortedBy { it.index }.groupBy { it.index }.map { it.value.map { it.value.toString() }.toMutableList() }.toMutableList()
    }

    private fun parseMove(input: String): Move {
        val data = input.filter { !it.isLetter() }.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
        return Move(amount = data[0], fromColumn = data[1] - 1, toColumn = data[2] - 1)
    }

    private fun parseAnswer(input: List<List<String>>): String {
        return input.joinToString("") { it.first().toString() }
    }

    override fun part1(input: List<String>): String {
        val splitIndex = input.withIndex().single { it.value.isEmpty() }.index
        val columns = parseBoxes(input.subList(0, splitIndex - 1))

        val moves = input.subList(splitIndex + 1, input.size)
        moves.forEach {
            val move = parseMove(it)
            val take = columns[move.fromColumn].take(move.amount)
            columns[move.toColumn].addAll(0, take.reversed())
            columns[move.fromColumn] = columns[move.fromColumn].drop(move.amount).toMutableList()
        }

        return parseAnswer(columns)
    }

    override fun part2(input: List<String>): String {
        val splitIndex = input.withIndex().single { it.value.isEmpty() }.index
        val columns = parseBoxes(input.subList(0, splitIndex - 1))

        val moves = input.subList(splitIndex + 1, input.size)
        moves.forEach {
            val move = parseMove(it)
            val take = columns[move.fromColumn].take(move.amount)
            columns[move.fromColumn] = columns[move.fromColumn].drop(move.amount).toMutableList()
            columns[move.toColumn].addAll(0, take)
        }

        return parseAnswer(columns)
    }
}
