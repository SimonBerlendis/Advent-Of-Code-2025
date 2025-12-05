import org.example.day02_part1
import org.example.day04_part1
import org.example.day04_part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day04Test {
    @Test
    fun day04_part1_circle() {
        val input = listOf(
            "....",
            ".@@@.",
            ".@.@.",
            ".@@@.",
            "....",
        )
        assertEquals(4, day04_part1(input))
    }

    @Test
    fun day04_part1_border() {
        val input = listOf(
            "@@@@",
            "@...@",
            "@...@",
            "@...@",
            "@@@@",
        )
        assertEquals(14, day04_part1(input))
    }

    @Test
    fun day04_part1_inside() {
        val input = listOf(
            "....",
            ".@@@.",
            ".@@@.",
            ".@@@.",
            "....",
        )
        assertEquals(4, day04_part1(input))
    }

    @Test
    fun day04_part1_survive() {
        val input = listOf(
            "....",
            ".@@.",
            "@@@@",
            "@@@@",
            ".@@.",
            "....",
        )
        assertEquals(0, day04_part1(input))
    }

    @Test
    fun day04_part2_circle() {
        val input = listOf(
            "....",
            ".@@@.",
            ".@.@.",
            ".@@@.",
            "....",
        )
        assertEquals(8, day04_part2(input))
    }

    @Test
    fun day04_part2_border() {
        val input = listOf(
            "@@@@",
            "@...@",
            "@...@",
            "@...@",
            "@@@@",
        )
        assertEquals(14, day04_part2(input))
    }

    @Test
    fun day04_part2_inside() {
        val input = listOf(
            "....",
            ".@@@.",
            ".@@@.",
            ".@@@.",
            "....",
        )
        assertEquals(9, day04_part2(input))
    }

    @Test
    fun day04_part2_survive() {
        val input = listOf(
            "....",
            ".@@.",
            "@@@@",
            "@@@@",
            ".@@.",
            "....",
        )
        assertEquals(0, day04_part2(input))
    }

}