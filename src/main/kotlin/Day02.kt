fun main() {
    fun part1(input: List<String>) = input.filter { it.isNotBlank() }
        .map { it.split(" ") }
        .map { Pair(RockPaperScissors.fromString(it.first()), RockPaperScissors.fromString(it[1])) }
        .sumOf { it.first.score(it.second) }

    fun part2(input: List<String>) = input.filter { it.isNotBlank() }
        .map { it.split(" ") }
        .map { Pair(RockPaperScissors.fromString(it.first()), it[1]) }
        .sumOf { it.first.score(it.second) }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputLines("day2/test")
    check(part1(testInput) == 15)

    val input = readInputLines("day2/input")
    println(part1(input))
    println(part2(input))
}

enum class RockPaperScissors(private val codes: List<String>, private val value: Int) {
    rock(listOf("A", "X"), 1),
    paper(listOf("B", "Y"), 2),
    scissors(listOf("C", "Z"), 3);

    fun score(mine: RockPaperScissors) = when {
        this == mine -> 3 + mine.value
        this == rock && mine == paper ||
                this == paper && mine == scissors ||
                this == scissors && mine == rock -> 6 + mine.value

        else -> 0 + mine.value
    }

    fun score(mine: String) = when {
        mine == "Y" -> 3 + this.value
        mine == "Z" -> 6 + this.pickWinner().value
        else -> this.pickLoser().value
    }

    fun pickLoser() = when {
        this == rock -> scissors
        this == paper -> rock
        else -> paper
    }

    fun pickWinner() = when {
        this == rock -> paper
        this == paper -> scissors
        else -> rock
    }

    companion object {
        fun fromString(value: String) = RockPaperScissors.values().first { value in it.codes }
    }
}
