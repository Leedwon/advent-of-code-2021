package day8

import org.junit.jupiter.api.Test
import util.readFileLines
import kotlin.test.assertEquals


internal class SevenSegmentsDisplayUtilsTest {

    private val sut = SevenSegmentsDisplayUtils()

    @Test
    fun `should correctly calculate unique display outputs`() {
        val lines = readFileLines("/day8_test_input.txt")

        val actual = sut.countUniqueOutputElements(lines)
        assertEquals(26, actual)
    }

    @Test
    fun `should correctly calculate output sum`() {
        val lines = readFileLines("/day8_test_input.txt")

        val actual = sut.calculateOutputsSum(lines)
        assertEquals(61229, actual)
    }
}