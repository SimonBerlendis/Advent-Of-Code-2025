import org.example.day02_part1
import org.example.day03_part1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day03Test {
    @Test
    fun day03_part1_12345() {
        val actual = day03_part1(listOf("12345"))
        assertEquals(45, actual)
    }

    @Test
    fun day03_part1_987654321111111() {
        val actual = day03_part1(listOf("987654321111111"))
        assertEquals(98, actual)
    }

    @Test
    fun day03_part1_234234234234278() {
        val actual = day03_part1(listOf("234234234234278"))
        assertEquals(78, actual)
    }

    @Test
    fun day03_part1_818181911112111() {
        val actual = day03_part1(listOf("818181911112111"))
        assertEquals(92, actual)
    }

}