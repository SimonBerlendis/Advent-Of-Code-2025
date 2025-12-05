import org.example.day05_part1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Test {
    @Test
    fun day05_part1() {
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

}