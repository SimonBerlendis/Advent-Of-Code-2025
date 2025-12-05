import org.example.day02_part1
import org.example.day04_part1
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

}