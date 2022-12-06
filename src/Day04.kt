class Day04 : AdventOfCode(2,4) {
    private fun getSectors(data: String): List<List<Int>>{
        return data.split(",").map {sectors ->
            val splitSectors = sectors.split("-")
            val range = IntRange(splitSectors[0].toInt(), splitSectors[1].toInt())
            range.toList()
        }
    }
    override fun part1(input: List<String>): Int {
        val result = input.map{ data ->
            val sectorRanges = getSectors(data)
            val compare = sectorRanges[0].containsAll(sectorRanges[1]) || sectorRanges[1].containsAll(sectorRanges[0])
            compare
        }
      return result.filter { it }.size
    }

    override fun part2(input: List<String>): Int {
        val result = input.map{ data ->
            val sectorRanges = getSectors(data)
            val compare = sectorRanges[0].any { sectorRanges[1].contains(it) } || sectorRanges[1].any { sectorRanges[0].contains(it) }
            compare
        }
        return result.filter { it }.size
    }
}
