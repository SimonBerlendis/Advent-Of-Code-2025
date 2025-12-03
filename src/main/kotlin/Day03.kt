package org.example

import readInput

fun main() {
    val testInput = readInput("Day03_test")
    println("Part 1: ")
    println(day03_part1(testInput))
    println("Part 2: ")
    println(day03_part2(testInput))
}

fun day03_part1(input: List<String>): Long {
    return input.sumOf { joltage(it, 2) }
}

fun day03_part2(input: List<String>): Long {
    return input.sumOf { joltage(it, 12) }
}

fun joltage(bank: String, nDigits: Int) : Long {
    var result = ""
    var remainingBatteries = bank
    for(i in 0..<nDigits){
        result += remainingBatteries.substring(0, remainingBatteries.length - nDigits + i + 1).max()
        remainingBatteries = remainingBatteries.substring(remainingBatteries.indexOf(result.last()) + 1)
    }
    return result.toLong()
}
