package org.example

import readInput
import java.math.BigInteger

fun main() {
    val testInput = readInput("Day03_test")
    println("Part 1: ")
    println(day03_part1(testInput))
    println("Part 2: ")
    println(day03_part2(testInput))
}

fun day03_part1(input: List<String>): BigInteger {
    return input.sumOf { joltage(it, 2) }
}

fun day03_part2(input: List<String>): BigInteger {
    return input.sumOf { joltage(it, 12) }
}

fun joltage(bank: String, nDigits: Int) : BigInteger {
    var result = ""
    for(i in 0..<nDigits){
        val start = if(result.isNotEmpty()) bank.indexOf(result.last()) + 1 else 0
        val end = bank.length - nDigits + i + 1
        result += bank.substring(start, end).max()
    }
    return result.toBigInteger()
}
