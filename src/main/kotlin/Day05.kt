package org.example

import readInput

fun main() {
    val testInput = readInput("Day05_test")
    println("Part 1: ")
    println(day05_part1(testInput))
    println("Part 2: ")
    println(day05_part2(testInput))
}

fun day05_part1(input: List<String>): Int {
    val ranges = ranges(input)
    val ids = getIds(input)
    return ids.count { id -> ranges.any{it.contains(id)} }
}

private fun getIds(input: List<String>): List<Long> =
    input.dropWhile { it.isNotEmpty() }.drop(1).map { it.toLong() }

private fun ranges(input: List<String>): List<LongRange> =
    input.takeWhile { it.isNotEmpty() }
        .map { it.split("-")[0].toLong()..it.split("-")[1].toLong() }

fun day05_part2(input: List<String>): Int {
    return 0
}
