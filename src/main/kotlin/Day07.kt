package org.example

import readInput

fun main() {
    val testInput = readInput("Day07_test")
    println("Part 1: ")
    println(day07_part1(testInput))
    println("Part 2: ")
    println(day07_part2(testInput))
}

fun day07_part1(input: List<String>): Int {
    var result = 0
    var beamPositions = "S".toRegex().findAll(input.first()).map { it.range.first }
    for (line in input.drop(1)) {
        val splitterPositions = "\\^".toRegex().findAll(line).map { it.range.first }
        result += splitterPositions.count { splitter -> beamPositions.any { beam -> beam == splitter } }
        beamPositions = beamPositions.flatMap { split(it, splitterPositions) }.distinct()
    }
    return result
}

private fun split(beam: Int, splitters: Sequence<Int>): List<Int> =
    if (splitters.contains(beam)) listOf(beam - 1, beam + 1) else listOf(beam)

fun day07_part2(input: List<String>): Int {
    return 0
}