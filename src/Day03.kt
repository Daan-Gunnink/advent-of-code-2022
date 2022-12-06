class Day03 : AdventOfCode(157, 70) {
    private val characterList = "abcdefghijklmnopqrstuvwxyz"

    private fun getScore(items: List<String>): Int {
        return items.map { it.toCharArray() }.map { it.sumOf {char ->
            if(char.isUpperCase()) (char.code - 38) else (char.code - 96)
        } }.sumOf { it }    }

    override fun part1(input: List<String>): Int {
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

    override fun part2(input: List<String>): Int {
        val groupSize = 3
        var totalScore = 0

        for (index in 0 until (input.size / groupSize)) {
            val groupIndex = (groupSize * index)
            val rucksacks = mutableListOf<List<String>>()
            for (elfIndex in 0 until groupSize) {
                val items = input[groupIndex + elfIndex].split("")
                rucksacks.add(items)
            }

            val result = rucksacks[0].mapNotNull { char ->
                if (rucksacks[1].any { it == char }) {
                    if (rucksacks[2].any { it == char }) {
                        char
                    } else null
                } else null
            }.filter { it.isNotEmpty() }.distinct()

            val score = getScore(result)

            totalScore += score
        }
        return totalScore
    }
}
