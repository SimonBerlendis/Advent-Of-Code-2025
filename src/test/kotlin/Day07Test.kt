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
        assertEquals(1, day07_part1(input))
    }

}