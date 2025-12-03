package org.example

import readInput

fun main() {
    val testInput = readInput("Day03_test")
    println("Part 1: ")
    println(day03_part1(testInput))
    println("Part 2: ")
    println(day03_part2(testInput))
}

fun day03_part1(input: List<String>): Int {
    return input.sumOf { joltage(it) }
}

fun joltage(bank: String) : Int {
    val firstDigit = bank.substring(0, bank.length-1).max()
    val secondDigit = bank.substring(bank.indexOf(firstDigit) + 1).max()
    return "$firstDigit$secondDigit".toInt()
}

fun day03_part2(input: List<String>): Int {
    return 0
}
