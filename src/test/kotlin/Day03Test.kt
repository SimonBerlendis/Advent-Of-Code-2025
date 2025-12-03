import org.example.day02_part1
import org.example.day03_part1
import org.example.joltage
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day03Test {
    @Test
    fun day03_part1_12345() {
        val actual = joltage("12345", 2)
        assertEquals(45.toBigInteger(), actual)
    }

    @Test
    fun day03_part1_987654321111111() {
        val actual = joltage("987654321111111", 2)
        assertEquals(98.toBigInteger(), actual)
    }

    @Test
    fun day03_part1_234234234234278() {
        val actual = joltage("234234234234278", 2)
        assertEquals(78.toBigInteger(), actual)
    }

    @Test
    fun day03_part1_818181911112111() {
        val actual = joltage("818181911112111", 2)
        assertEquals(92.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_12345() {
        val actual = joltage("12345", 3)
        assertEquals(345.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_987654321111111() {
        val actual = joltage("987654321111111", 3)
        assertEquals(987.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_811111111111119() {
        val actual = joltage("811111111111119", 3)
        assertEquals(819.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_234234234234278() {
        val actual = joltage("234234234234278", 3)
        assertEquals(478.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_818181911112111() {
        val actual = joltage("818181911112111", 3)
        assertEquals(921.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_987654321111111_for_12() {
        val actual = joltage("987654321111111", 12)
        assertEquals(987654321111.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_811111111111119_for_12() {
        val actual = joltage("811111111111119", 12)
        assertEquals(811111111119.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_234234234234278_for_12() {
        val actual = joltage("234234234234278", 12)
        assertEquals(434234234278.toBigInteger(), actual)
    }

    @Test
    fun day03_part2_818181911112111_for_12() {
        val actual = joltage("818181911112111", 12)
        assertEquals(888911112111.toBigInteger(), actual)
    }
}