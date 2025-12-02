package org.example

import readInput
import java.lang.Math.floorMod

fun main() {
    val testInput = readInput("Day01_test")
    print(solve(testInput))
}

fun solve(input: List<String>): Int {
    var password = 0

    var dial = 50
    for (instruction in input) {
        dial += (if ("R" in instruction) 1 else -1) * instruction.drop(1).toInt()
        dial = floorMod(dial, 100)
        if(dial == 0) password++
    }

    return password
}