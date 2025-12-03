package org.example

import readInput
import step
import sum
import java.math.BigInteger

fun main() {
    val testInput = readInput("Day02_test").first()
    println("Part 1: ")
    println(day02_part1(testInput))
//    println("Part 2: ")
//    println(part2(testInput))
}

fun day02_part1(input: String): BigInteger {
    return ranges(input).sumOf { range -> sumOfInvalidIds(range) }
}

private fun sumOfInvalidIds(range: ClosedRange<BigInteger>) : BigInteger {
    return range.step().filter { it.isInvalid() }.sum()
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

private fun ranges(input: String): List<ClosedRange<BigInteger>> {
    return input.split(",").map { it.split("-")[0].toBigInteger()..it.split("-")[1].toBigInteger() }
}

fun day02_part2(input: List<String>): Int {
    return 0
}