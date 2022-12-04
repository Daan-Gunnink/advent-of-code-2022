fun main() {
    fun getSectors(data: String): List<List<Int>>{
        return data.split(",").map {sectors ->
            val splitSectors = sectors.split("-")
            val range = IntRange(splitSectors[0].toInt(), splitSectors[1].toInt())
            range.toList()
        }
    }
    fun part1(input: List<String>): Int {
        val result = input.map{ data ->
            val sectorRanges = getSectors(data)
            val compare = sectorRanges[0].containsAll(sectorRanges[1]) || sectorRanges[1].containsAll(sectorRanges[0])
            compare
        }
      return result.filter { it }.size
    }

    fun part2(input: List<String>): Int {
        val result = input.map{ data ->
            val sectorRanges = getSectors(data)
            val compare = sectorRanges[0].any { sectorRanges[1].contains(it) } || sectorRanges[1].any { sectorRanges[0].contains(it) }
            compare
        }
        return result.filter { it }.size
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)


    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
