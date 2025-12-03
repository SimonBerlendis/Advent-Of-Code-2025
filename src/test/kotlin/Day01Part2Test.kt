import org.example.day02_part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Part2Test {
    @Test
    fun right() {
        assertEquals(0, day02_part2(listOf("R10")))
    }

    @Test
    fun left() {
        assertEquals(0, day02_part2(listOf("L10")))
    }

    @Test
    fun right_to_zero() {
        assertEquals(1, day02_part2(listOf("R50")))
    }

    @Test
    fun left_to_zero() {
        assertEquals(1, day02_part2(listOf("L50")))
    }

    @Test
    fun right_once() {
        assertEquals(1, day02_part2(listOf("R60")))
    }

    @Test
    fun left_once() {
        assertEquals(1, day02_part2(listOf("L60")))
    }

    @Test
    fun right_twice() {
        assertEquals(2, day02_part2(listOf("R160")))
    }

    @Test
    fun left_twice() {
        assertEquals(2, day02_part2(listOf("L160")))
    }

    @Test
    fun right_exacty_zero() {
        assertEquals(2, day02_part2(listOf("R150")))
    }

    @Test
    fun left_exactly_zero() {
        assertEquals(2, day02_part2(listOf("L150")))
    }

    @Test
    fun right_three() {
        assertEquals(3, day02_part2(listOf("R260")))
    }

    @Test
    fun left_three() {
        assertEquals(3, day02_part2(listOf("L260")))
    }

    @Test
    fun right_ten() {
        assertEquals(10, day02_part2(listOf("R1000")))
    }

    @Test
    fun left_from_zero() {
        assertEquals(1, day02_part2(listOf("L50", "L5")))
    }

    @Test
    fun left_from_zero_to_far() {
        assertEquals(day02_part2(listOf("L200")), day02_part2(listOf("L50", "L150")))
    }

    @Test
    fun right_from_zero_to_far() {
        assertEquals(day02_part2(listOf("R300")), day02_part2(listOf("R50", "R250")))
    }

    @Test
    fun right_testcase() {
        assertEquals(6, day02_part2(listOf("L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82")))
    }
}