import org.example.day02_part1
import org.example.day02_part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun eleven() {
        val actual = day02_part1("10-12")
        assertEquals(11.toBigInteger(), actual)
    }

    @Test
    fun twentytwo() {
        val actual = day02_part1("15-25")
        assertEquals(22.toBigInteger(), actual)
    }

    @Test
    fun extremity_values() {
        val actual = day02_part1("11-22")
        assertEquals(33.toBigInteger(), actual)
    }

    @Test
    fun sixtyfour_twice() {
        val actual = day02_part1("6463-6465")
        assertEquals(6464.toBigInteger(), actual)
    }

    @Test
    fun bigdecimal() {
        val actual = day02_part1("4444385428-4444385429")
        assertEquals(0.toBigInteger(), actual)
    }

}