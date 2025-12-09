package org.example

import readInput

fun main() {
    val testInput = readInput("Day08_test")
    println("Part 1: ")
    println(day08_part1(testInput, 1000))
    println("Part 2: ")
    println(day08_part2(testInput))
}

data class Point(val x: Int, val y: Int, val z: Int) {
    fun distance(otherPoint: Point): Int {
        return (x - otherPoint.x) * (x - otherPoint.x) +
                (y - otherPoint.y) * (y - otherPoint.y) +
                (z - otherPoint.z) * (z - otherPoint.z)
    }
}

fun day08_part1(input: List<String>, connectionsMax: Int): Int {
    val points = getPoints(input)

    val connections = (0..<points.size - 1).flatMap { i -> ((i + 1)..<points.size).map { j -> i to j } }
        .sortedBy { points[it.first].distance(points[it.second]) }
        .take(connectionsMax)

    val circuit = buildCircuit(connections)

    return circuit.map { it.size }.sorted().take(3).reduce { acc, i -> acc * i }
}

fun buildCircuit(connections: List<Pair<Int, Int>>): List<List<Int>> {
    val circuit = mutableListOf<MutableList<Pair<Int, Int>>>()
    for (connection in connections) {
        if (circuit.any { it.flatMap { it.toList() }.containsAll(connection.toList()) }) {
            continue
        } else if (circuit.any { it.flatMap { it.toList() }.contains(connection.first) }) {
            circuit.first { it.flatMap { it.toList() }.contains(connection.first) }.add(connection)
        } else if (circuit.any { it.flatMap { it.toList() }.contains(connection.second) }) {
            circuit.first { it.flatMap { it.toList() }.contains(connection.second) }.add(connection)
        } else {
            circuit.add(mutableListOf(connection))
        }
    }
    return circuit.map { it.flatMap { it.toList() } }.merge()
}

private fun List<List<Int>>.merge(): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    for (elements in this) {
        if(result.any { it.any { elements.contains(it) } }){
            result.first { it.any { elements.contains(it) } }.addAll(elements)
        } else {
            result.add(elements.toMutableList())
        }
    }
    return result.map { it.distinct() }
}

private fun getPoints(input: List<String>): List<Point> =
    input.map { line -> line.split(",").map { it.toInt() } }
        .map { Point(it[0], it[1], it[2]) }

fun day08_part2(input: List<String>): Int {
    return 0
}
