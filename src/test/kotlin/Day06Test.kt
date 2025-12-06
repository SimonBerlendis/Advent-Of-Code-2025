import org.example.day05_part1
import org.example.day06_part1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day06Test {
    @Test
    fun day06_part1_1plus1() {
        val input = listOf(
            "1",
            "1",
            "+",
        )
        assertEquals(2, day06_part1(input))
    }

    @Test
    fun day06_part1_2plus2plus2() {
        val input = listOf(
            "2",
            "2",
            "2",
            "+",
        )
        assertEquals(6, day06_part1(input))
    }

    @Test
    fun day06_part1_3times3() {
        val input = listOf(
            "3",
            "3",
            "*",
        )
        assertEquals(9, day06_part1(input))
    }

    @Test
    fun day06_part1_two_operations() {
        val input = listOf(
            "3   1",
            "3  1",
            "* +",
        )
        assertEquals(11, day06_part1(input))
    }

}