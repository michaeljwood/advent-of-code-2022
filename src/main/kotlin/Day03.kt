fun main() {
    fun part1(input: List<String>) = input.filter { it.isNotBlank() }
        .map {
            Pair(
                it.substring(0, it.length / 2).toCharArray().toSet(),
                it.substring(it.length / 2).toCharArray().toSet()
            )
        }
        .map { it.first.intersect(it.second) }
        .sumOf { chars.indexOf(it.first()) + 1 }

    fun part2(input: List<String>) = input.filter { it.isNotBlank() }
        .chunked(3)
        .map { it.first().toCharArray().intersect(it[1].toCharArray().toSet()).intersect(it[2].toCharArray().toSet()) }
        .sumOf { chars.indexOf(it.first()) + 1 }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputLines("day3/test")
    check(part1(testInput) == 157)

    val input = readInputLines("day3/input")
    println(part1(input))
    println(part2(input))
}

private val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
