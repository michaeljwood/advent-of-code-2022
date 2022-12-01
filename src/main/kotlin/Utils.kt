import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

private const val RESOURCE_ROOT = "src/main/resources"

/**
 * Reads lines from the given input txt file.
 */
fun readInputLines(name: String) = File(RESOURCE_ROOT, "$name.txt")
    .readLines()

/**
 * Read the input file as a single string.
 */
fun readInput(name: String) = File(RESOURCE_ROOT, "$name.txt").readText()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
