data class Move(
        val amount: Int,
        val fromColumn: Int,
        val toColumn: Int
)

fun parseBoxes(input: List<String>): MutableList<MutableList<String>> {
    return input.map { it.withIndex().filter { it.value.isLetter() } }.flatten().sortedBy { it.index }.groupBy { it.index }.map { it.value.map { it.value.toString() }.toMutableList() }.toMutableList()
}

fun parseMove(input: String): Move {
    val data = input.filter { !it.isLetter() }.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    return Move(amount = data[0], fromColumn = data[1] - 1, toColumn = data[2] - 1)
}

fun parseAnswer(input: List<List<String>>): String{
    return input.joinToString("") { it.first().toString() }
}


fun main() {
    fun part1(input: List<String>): String {
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

    fun part2(input: List<String>): String {
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

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")


    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
