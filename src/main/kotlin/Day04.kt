fun main() {
    fun part1(input: List<String>) = inputLinesToRangePairs(input).count { it.first.overlapsFully(it.second) }

    fun part2(input: List<String>) = inputLinesToRangePairs(input).count { it.first.overlaps(it.second) }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputLines("day4/test")
    check(part1(testInput) == 2)

    val input = readInputLines("day4/input")
    println(part1(input))
    println(part2(input))
}

private fun inputLinesToRangePairs(input: List<String>) = input.filter { it.isNotBlank() }
    .map {
        it.split(",")
            .map { section -> section.split("-").map { bound -> bound.toInt() } }
            .let { sections ->
                Pair(
                    IntRange(sections[0][0], sections[0][1]),
                    IntRange(sections[1][0], sections[1][1])
                )
            }
    }

private fun IntRange.overlapsFully(other: IntRange) =
    (this.contains(other.first) && this.contains(other.last)) || (other.contains(this.first) && other.contains(this.last))

private fun IntRange.overlaps(other: IntRange) =
    this.contains(other.first) || this.contains(other.last) || other.contains(this.first) || other.contains(this.last)
