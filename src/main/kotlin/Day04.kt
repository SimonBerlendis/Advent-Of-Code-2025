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

fun day04_part1(input: List<String>): Int {
    val grid = input.map { line -> line.map { if (it == '.') 0 else 1 } }
    return accessibleRollCount(grid)
}

fun day04_part2(input: List<String>): Int {
    val grid = input.map { line -> line.map { if (it == '.') 0 else 1 } }
    return totalRollCount(grid)
}

fun totalRollCount(grid: List<List<Int>>): Int {
    val currentGridRollCount = accessibleRollCount(grid)
    if(currentGridRollCount == 0) return 0

    val newGrid = removeAccessibleRolls(grid)
    return currentGridRollCount + totalRollCount(newGrid)
}

fun removeAccessibleRolls(grid: List<List<Int>>) : List<List<Int>> {
    return grid.mapIndexed { row, line -> line.mapIndexed { col, cell -> if (grid.neighborsRollCount(row, col) < 4) 0 else cell } }
}

fun accessibleRollCount(grid: List<List<Int>>): Int {
    return grid.flatMapIndexed { row, line -> line.filterIndexed { col, _ -> grid.neighborsRollCount(row, col) < 4 } }.sum()
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

