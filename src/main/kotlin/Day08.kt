package org.example

import readInput

fun main() {
    val testInput = readInput("Day08_test")
    println("Part 1: ")
    println(day08_part1(testInput, 1000))
    println("Part 2: ")
    println(day08_part2(testInput))
}

data class Point(val x: Long, val y: Long, val z: Long) {
    fun distance(otherPoint: Point): Long {
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

    val circuits = buildCircuits(connections)

    return circuits.map { it.size }.sortedDescending().take(3).reduce { acc, i -> acc * i }
}

fun buildCircuits(connections: List<Pair<Int, Int>>): List<List<Int>> {
    val circuits = connections.map { it.toList() }.toMutableList()
    for (connection in connections) {
        val circuitsToMerge = circuits.filter { it.contains(connection.first) || it.contains(connection.second) }
        circuits.removeAll(circuitsToMerge)
        circuits.add((circuitsToMerge.flatten() + connection.toList()).toMutableList())
    }
    return circuits.map { it.distinct() }
}

private fun getPoints(input: List<String>): List<Point> =
    input.map { line -> line.split(",").map { it.toLong() } }
        .map { Point(it[0], it[1], it[2]) }

fun day08_part2(input: List<String>): Long {
    val points = getPoints(input)

    val circuit = buildSingleCircuit(points)

    val firstPoint = points[circuit.last().first]
    val secondPoint = points[circuit.last().second]
    return firstPoint.x * secondPoint.x
}

fun buildSingleCircuit(points: List<Point>): List<Pair<Int, Int>> {
    val closestPairs = (0..<points.size - 1).flatMap { i -> ((i + 1)..<points.size).map { j -> i to j } }
        .sortedBy { points[it.first].distance(points[it.second]) }

    val circuits = points.indices.map { listOf(it) }.toMutableList()
    for ((index, connection) in closestPairs.withIndex()) {
        if (circuits.size == 1) {
            return closestPairs.take(index)
        }
        val circuitsToMerge = circuits.filter { it.contains(connection.first) || it.contains(connection.second) }
        circuits.removeAll(circuitsToMerge)
        circuits.add((circuitsToMerge.flatten() + connection.toList()).toMutableList())
    }

    return closestPairs
}
