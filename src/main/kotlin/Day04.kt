package org.example

import readInput
import kotlin.math.max
import kotlin.math.min

fun main() {
    val testInput = readInput("Day04_test")
    println("Part 1: ")
    println(day04_part1(testInput))
    println("Part 2: ")
    println(day04_part2(testInput))
}

private fun String.convertIntoGridLine(): List<Int> =
    replace(".", "0").replace("@", "1").split("").filter { it.isNotEmpty() }.map { it.toInt() }

fun day04_part1(input: List<String>): Int {
    val grid = input.map { line -> line.convertIntoGridLine() }
    return countAccessibleRoll(grid)
}

fun day04_part2(input: List<String>): Int {
    return 0
}

fun countAccessibleRoll(grid: List<List<Int>>): Int {
    return grid.flatMapIndexed { row, line -> line.filterIndexed { col, _ -> grid.neighborsRollCount(row, col) != 8 } }.sum()
}

private fun List<List<Int>>.neighborsRollCount(row: Int, col: Int): Int {
    var result = 0

    val minRow = max(row - 1, 0)
    val maxRow = min(row + 1, size - 1)
    for (i in minRow..maxRow) {
        val line = this[i]
        val minCol = max(col - 1, 0)
        val maxCol = min(col + 1, line.size - 1)

        for (j in minCol..maxCol) {
            if (i == row && j == col) continue
            result += line[j]
        }
    }
    return result
}

