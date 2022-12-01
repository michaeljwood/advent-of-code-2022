fun main() {
    fun part1(input: String) = input.split("\n\n").map { line ->
        line.split("\n").filter { it.isNotBlank() }.map { cal -> cal.toInt() }
    }.maxOfOrNull { it.sum() }

    fun part2(input: String) = input.split("\n\n").map { line ->
        line.split("\n").filter { it.isNotBlank() }.map { cal -> cal.toInt() }
    }.map { it.sum() }.sortedDescending().take(3).sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day1/test")
    check(part1(testInput) == 24000)

    val input = readInput("day1/input")
    println(part1(input))
    println(part2(input))
}
