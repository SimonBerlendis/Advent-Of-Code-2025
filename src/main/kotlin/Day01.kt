package org.example

import readInput
import java.lang.Math.floorMod

fun main() {
    val testInput = readInput("Day01_test")
    println("Part 1: ")
    println(part1(testInput))
    println("Part 2: ")
    println(part2(testInput))
}

fun part1(input: List<String>): Int {
    var password = 0

    var dial = 50
    for (instruction in input) {
        dial += (if ("R" in instruction) 1 else -1) * instruction.drop(1).toInt()
        dial = floorMod(dial, 100)
        if(dial == 0) password++
    }

    return password
}

fun part2(input: List<String>): Int {
    var password = 0

    var dial = 50
    for (instruction in input) {
        val previous = dial
        dial += (if ("R" in instruction) 1 else -1) * instruction.drop(1).toInt()

        password += (if(dial < 1) (100 - dial) / 100 - (if (previous == 0) 1 else 0) else dial / 100)

        dial = floorMod(dial, 100)
    }

    return password
}