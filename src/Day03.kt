fun main() {
    val characterList = "abcdefghijklmnopqrstuvwxyz"

    fun getScore(items: List<String>): Int {
        val score = items.map {
            var points = 0
            it.toCharArray().forEach {
                points += characterList.indexOf(it, 0, true) + 1
                if (it.isUpperCase()) points += 26
            }
            points
        }

        return score.sum()
    }

    fun part1(input: List<String>): Int {
        val result = input.map {
            val firstHalf = it.take(it.length / 2).split("")
            val secondHalf = it.takeLast(it.length / 2).split("")
            firstHalf.map { char ->
                if (secondHalf.any { it == char }) {
                    char
                } else null
            }.filterNotNull().filter { it.isNotEmpty() }.distinct()
        }

        return getScore(result.flatten())
    }

    fun part2(input: List<String>): Int {
        val groupSize = 3
        var totalScore = 0

        for (index in 0 until (input.size / groupSize)) {
            val groupIndex = (groupSize * index)
            val rucksacks = mutableListOf<List<String>>()
            for (elfIndex in 0 until groupSize) {
                val items = input[groupIndex + elfIndex].split("")
                rucksacks.add(items)
            }

            val result = rucksacks[0].map { char ->
                if (rucksacks[1].any { it == char }) {
                    if (rucksacks[2].any { it == char }) {
                        char
                    } else null
                } else null
            }.filterNotNull().filter { it.isNotEmpty() }.distinct()

            val score = getScore(result)

            totalScore += score
        }
        return totalScore
    }


// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)


    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
