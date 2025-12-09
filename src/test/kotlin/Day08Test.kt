import org.example.buildCircuit
import org.example.day08_part1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertContentEquals

class Day08Test {
    @Test
    fun buildCircuit_with_one_connection() {
        val connections = listOf(1 to 2)
        assertContains(buildCircuit(connections), listOf(1, 2))
    }

    @Test
    fun buildCircuit_with_two_connection() {
        val connections = listOf(1 to 2, 3 to 4)
        val expected = listOf(listOf(1, 2), listOf(3, 4))
        assertContentEquals(expected, buildCircuit(connections))
    }

    @Test
    fun day08_part1_toto() {
        val input = listOf(
            "162,817,812",
            "57,618,57",
            "906,360,560",
            "592,479,940",
            "352,342,300",
            "466,668,158",
            "542,29,236",
            "431,825,988",
            "739,650,466",
            "52,470,668",
            "216,146,977",
            "819,987,18",
            "117,168,530",
            "805,96,715",
            "346,949,466",
            "970,615,88",
            "941,993,340",
            "862,61,35",
            "984,92,344",
            "425,690,689",
        )
        assertEquals(40, day08_part1(input, 10))
    }

}