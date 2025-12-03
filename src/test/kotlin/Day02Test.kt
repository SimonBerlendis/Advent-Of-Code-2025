import org.example.day02_part1
import org.example.day02_part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun part1_eleven() {
        val actual = day02_part1("10-12")
        assertEquals(11.toBigInteger(), actual)
    }

    @Test
    fun part1_twentytwo() {
        val actual = day02_part1("15-25")
        assertEquals(22.toBigInteger(), actual)
    }

    @Test
    fun part1_extremity_values() {
        val actual = day02_part1("11-22")
        assertEquals(33.toBigInteger(), actual)
    }

    @Test
    fun part1_sixtyfour_twice() {
        val actual = day02_part1("6463-6465")
        assertEquals(6464.toBigInteger(), actual)
    }

    @Test
    fun part1_bigdecimal() {
        val actual = day02_part1("4444385428-4444385429")
        assertEquals(0.toBigInteger(), actual)
    }

    @Test
    fun part2_eleven() {
        val actual = day02_part2("10-12")
        assertEquals(11.toBigInteger(), actual)
    }

    @Test
    fun part2_twentytwo() {
        val actual = day02_part2("15-25")
        assertEquals(22.toBigInteger(), actual)
    }

    @Test
    fun part2_extremity_values() {
        val actual = day02_part2("11-22")
        assertEquals(33.toBigInteger(), actual)
    }

    @Test
    fun part2_sixtyfour_twice() {
        val actual = day02_part2("6463-6465")
        assertEquals(6464.toBigInteger(), actual)
    }

    @Test
    fun part2_bigdecimal() {
        val actual = day02_part2("4444385428-4444385429")
        assertEquals(0.toBigInteger(), actual)
    }

    @Test
    fun part2_three_sequence() {
        val actual = day02_part2("123123122-123123124")
        assertEquals(123123123.toBigInteger(), actual)
    }

    @Test
    fun part2_five_sequence() {
        val actual = day02_part2("1212121212-1212121213")
        assertEquals(1212121212.toBigInteger(), actual)
    }

    @Test
    fun part2_only_one_digit() {
        val actual = day02_part2("1111111-1111112")
        assertEquals(1111111.toBigInteger(), actual)
    }

    @Test
    fun part2_single_digit() {
        val actual = day02_part2("1-9")
        assertEquals(0.toBigInteger(), actual)
    }

}