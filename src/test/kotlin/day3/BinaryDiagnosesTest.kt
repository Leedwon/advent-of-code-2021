package day3

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class BinaryDiagnosesTest {

    private val diagnoses = BinaryDiagnoses()

    @ParameterizedTest
    @MethodSource("power consumption diagnoses source")
    fun `test power consumption diagnoses`(data: TestData) {
        val result = diagnoses.diagnosePowerConsumption(data.input, data.bitSize)
        assertEquals(data.expected, result)
    }

    @ParameterizedTest
    @MethodSource("life support rating diagnoses source")
    fun `test life support rating diagnoses`(data: TestData) {
        val result = diagnoses.diagnoseLifeSupportRating(data.input, data.bitSize)
        assertEquals(data.expected, result.toUInt())
    }
    
    companion object {
        data class TestData(
            val input: List<Int>,
            val bitSize: Int,
            val expected: UInt
        )

        @JvmStatic
        @Suppress("unused")
        fun `power consumption diagnoses source`() = listOf(
            TestData(
                input = listOf(0b1),
                bitSize = 1,
                expected = 0b0U
            ),
            TestData(
                input = listOf(0b1, 0b10, 0b11),
                bitSize = 2,
                expected = 0b11U * 0b00U
            ),
            TestData(
                input = listOf(0b1, 0b10, 0b10),
                bitSize = 2,
                expected = 0b10U * 0b01U
            ),
            TestData(
                input = listOf(
                    0b00100,
                    0b11110,
                    0b10110,
                    0b10111,
                    0b10101,
                    0b01111,
                    0b00111,
                    0b11100,
                    0b10000,
                    0b11001,
                    0b00010,
                    0b01010,
                ),
                bitSize = 5,
                expected = 198U
            )
        )

        @JvmStatic
        @Suppress("unused")
        fun `life support rating diagnoses source`() = listOf(
            TestData(
                input = listOf(
                    0b00100,
                    0b11110,
                    0b10110,
                    0b10111,
                    0b10101,
                    0b01111,
                    0b00111,
                    0b11100,
                    0b10000,
                    0b11001,
                    0b00010,
                    0b01010,
                ),
                bitSize = 5,
                expected = 230U
            )
        )
    }

}