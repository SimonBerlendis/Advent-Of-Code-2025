import org.example.day05_part1
import org.example.day05_part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Test {
    @Test
    fun day05_part1_give_number_fresh_ingredients() {
        val input = listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32",
        )
        assertEquals(3, day05_part1(input))
    }

    @Test
    fun day05_part2_give_number_fresh_ids() {
        val input = listOf(
            "3-5",
            "10-14",
            "11-12",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32",
        )
        assertEquals(14, day05_part2(input))
    }

    @Test
    fun day05_part2_overlapping_from_last() {
        val input = listOf(
            "10-14",
            "13-20",
            "70-80",
            "78-80",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32",
        )
        assertEquals(22, day05_part2(input))
    }

    @Test
    fun day05_part2_overlapping_from_first() {
        val input = listOf(
            "10-14",
            "13-20",
            "30-40",
            "30-32",
            "50-52",
            "50-60",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32",
        )
        assertEquals(33, day05_part2(input))
    }
}