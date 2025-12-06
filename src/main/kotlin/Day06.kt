package org.example

import readInput

fun main() {
    val testInput = readInput("Day06_test")
    println("Part 1: ")
    println(day06_part1(testInput))
    println("Part 2: ")
    println(day06_part2(testInput))
}

fun day06_part1(input: List<String>): Long {
    val numbersPerLine = getNumberPerLine(input)
    val numbersPerProblem = getNumbersPerProblem(numbersPerLine)
    val operations = getOperationsPerProblem(input)
    return numbersPerProblem.zip(operations).sumOf { (numbers, operation) -> solve(numbers, operation) }
}

private fun getNumberPerLine(input: List<String>): List<List<Long>> =
    input.dropLast(1).map { line -> line.split(" ").filter { it.isNotEmpty() }.map { it.toLong() } }

private fun getNumbersPerProblem(numbersPerLine: List<List<Long>>): List<List<Long>> {
    val numberOfProblems = numbersPerLine.first().size
    return (0..<numberOfProblems).map { indexProblem -> numbersPerLine.map { line -> line[indexProblem] } }
}

private fun getOperationsPerProblem(input: List<String>): List<String> =
    input.last().split(" ").filter { it.isNotEmpty() }

private fun solve(numbers: List<Long>, operation: String): Long =
    if (operation == "+") numbers.sum() else numbers.reduce { acc, i -> acc * i }

fun day06_part2(input: List<String>): Long {
    return 0
}
