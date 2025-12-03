package org.example

import readInput
import step
import sum
import java.math.BigInteger

fun main() {
    val testInput = readInput("Day02_test").first()
    println("Part 1: ")
    println(day02_part1(testInput))
    println("Part 2: ")
    println(day02_part2(testInput))
}

private fun ranges(input: String): List<ClosedRange<BigInteger>> {
    return input.split(",").map { it.split("-")[0].toBigInteger()..it.split("-")[1].toBigInteger() }
}

fun day02_part1(input: String): BigInteger {
    return ranges(input).sumOf { range -> range.step().filter { it.isInvalid() }.sum() }
}

private fun BigInteger.isInvalid(): Boolean {
    val string = toString()
    val length = string.length

    if(length % 2 != 0){
        return false
    }

    val first = string.substring(0, length / 2).toBigInteger()
    val second = string.substring(length / 2).toBigInteger()
    return first == second
}

fun day02_part2(input: String): BigInteger {
    return ranges(input).sumOf { range -> range.step().filter { it.isInvalidPart2() }.sum() }
}

private fun BigInteger.isInvalidPart2(): Boolean {
    val string = toString()
    val length = string.length

    for (i in 2..length){
        if (length % i != 0) continue

        val substrings = (0..length step length / i).zipWithNext().map { (start, end) -> string.substring(start, end) }
        if (substrings.distinct().size == 1) return true
    }

    return false
}
