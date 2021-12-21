package day11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import util.readFileLines

internal class OctopusFlashCounterTest {

    private val sut = OctopusFlashCounter()

    @ParameterizedTest
    @MethodSource("provide test params")
    fun `should calculate flashes correctly`(params: TestParams) {
        val input  = readFileLines("/day11_test_input.txt")
        val initialState = input.map { it.map { Character.getNumericValue(it) } }

        val actual = sut.countOctopusFlashesAfter(initialState, params.steps)

        assertEquals(params.expected, actual)
    }

    @Test
    fun `should calculate flashes correctly for smaller input`() {
        val input  = readFileLines("/day11_test_input_2.txt")
        val initialState = input.map { it.map { Character.getNumericValue(it) } }

        val actual = sut.countOctopusFlashesAfter(initialState, 2)

        assertEquals(9, actual)
    }

    @Test
    fun `should correctly calculate first synchronized flash step`() {
        val input  = readFileLines("/day11_test_input.txt")
        val initialState = input.map { it.map { Character.getNumericValue(it) } }

        val actual = sut.getFirstSynchronizedFlashStep(initialState)

        assertEquals(195, actual)
    }

    companion object {
        data class TestParams(
            val steps: Int,
            val expected: Int
        )

        @JvmStatic
        fun `provide test params`() = listOf(
            TestParams(steps = 1, expected=  0),
            TestParams(steps = 2, expected=  35),
            TestParams(steps = 10, expected = 204),
            TestParams(steps = 100, expected = 1656),
        )
    }
}