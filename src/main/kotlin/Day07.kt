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
    val beamPositions = "S".toRegex().findAll(input.first()).map { it.range.first }
    return splitCount(input.drop(1), beamPositions)
}

private fun splitCount(manifold: List<String>, beamPositions: Sequence<Int>): Int {
    if (manifold.isEmpty()) return 0
    val manifoldLine = manifold.first()

    val splitterPositions = "\\^".toRegex().findAll(manifoldLine).map { it.range.first }
    val splitCount = splitterPositions.count { splitter -> beamPositions.any { beam -> beam == splitter } }

    val newBeamPositions = beamPositions.flatMap { split(it, splitterPositions) }.distinct()
    val remainingManifold = manifold.drop(1)
    return splitCount + splitCount(remainingManifold, newBeamPositions)
}

private fun split(beam: Int, splitters: Sequence<Int>): List<Int> =
    if (splitters.contains(beam)) listOf(beam - 1, beam + 1) else listOf(beam)

fun day07_part2(input: List<String>): Int {
    return 0
}