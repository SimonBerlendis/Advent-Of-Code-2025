package org.example

import readInput

fun main() {
    val testInput = readInput("Day05_test")
    println("Part 1: ")
    println(day05_part1(testInput))
    println("Part 2: ")
    println(day05_part2(testInput))
}

private fun ranges(input: List<String>): List<LongRange> =
    input.takeWhile { it.isNotEmpty() }
        .map { it.split("-")[0].toLong()..it.split("-")[1].toLong() }

fun day05_part1(input: List<String>): Int {
    val ranges = ranges(input)
    val ids = getIds(input)
    return ids.count { id -> ranges.any{it.contains(id)} }
}

private fun getIds(input: List<String>): List<Long> =
    input.dropWhile { it.isNotEmpty() }.drop(1).map { it.toLong() }

fun day05_part2(input: List<String>): Long {
    val ranges = ranges(input)
    return ranges.countTotalIds()
}

private fun List<LongRange>.countTotalIds(): Long {
    var result = 0.toLong()

    val sortedRanges = this.sortedBy { it.start }
    var currentRange = sortedRanges.first()
    for (range in sortedRanges.drop(1)) {
        if (!currentRange.contains(range.start)) {
            result += (currentRange.endInclusive - currentRange.start) + 1
            currentRange = range
        }
        if (!currentRange.contains(range.endInclusive)){
            currentRange = currentRange.start..range.endInclusive
        }
    }
    result += (currentRange.endInclusive - currentRange.start) + 1

    return result
}
