import org.example.day07_part1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day07Test {
    @Test
    fun day07_part1_one_beam() {
        val input = listOf(
            ".S.",
            "...",
            "...",
        )
        assertEquals(0, day07_part1(input))
    }

    @Test
    fun day07_part1_splitter_untouched() {
        val input = listOf(
            ".S.",
            "^..",
            "...",
        )
        assertEquals(0, day07_part1(input))
    }

    @Test
    fun day07_part1_one_splitter() {
        val input = listOf(
            ".S.",
            "...",
            ".^.",
            "...",
        )
        assertEquals(1, day07_part1(input))
    }

    @Test
    fun day07_part1_two_splitter() {
        val input = listOf(
            "..S..",
            ".....",
            "..^..",
            ".....",
            ".^...",
            ".....",
        )
        assertEquals(2, day07_part1(input))
    }

    @Test
    fun day07_part1_splitter_on_same_line() {
        val input = listOf(
            "..S...S..",
            ".........",
            "..^...^..",
            ".........",
        )
        assertEquals(2, day07_part1(input))
    }

    @Test
    fun day07_part1_split_into_same_beam() {
        val input = listOf(
            ".S.S.",
            ".....",
            ".^.^.",
            ".....",
        )
        assertEquals(2, day07_part1(input))
    }

    @Test
    fun day07_part1_use_case() {
        val input = listOf(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "...............",
        )
        assertEquals(21, day07_part1(input))
    }
}