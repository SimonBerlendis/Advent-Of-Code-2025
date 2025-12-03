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
    return input.sumOf { joltage(it, 2) }
}

fun day03_part2(input: List<String>): Int {
    return input.sumOf { joltage(it, 12) }
}

fun joltage(bank: String, nDigits: Int) : Int {
    if(nDigits == 2){
        val firstDigit = bank.take(bank.length - 1).max()
        val secondDigit = bank.drop(bank.indexOf(firstDigit) + 1).max()
        return "$firstDigit$secondDigit".toInt()
    } else if (nDigits == 3) {
        val firstDigit = bank.take(bank.length - 2).max()
        val secondDigit = bank.substring(bank.indexOf(firstDigit) + 1, bank.length - 1).max()
        val thirdDigit = bank.drop(bank.indexOf(secondDigit) + 1).max()
        return "$firstDigit$secondDigit$thirdDigit".toInt()
    }

    return 0
}
