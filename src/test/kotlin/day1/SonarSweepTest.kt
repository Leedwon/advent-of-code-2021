package day1

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class SonarSweepTest {

    private val sonarSweep = SonarSweep()

    @ParameterizedTest
    @MethodSource("depth increase data")
    fun `test calculateDepthIncreaseSpeed`(data: TestData) {
        val result = sonarSweep.calculateDepthIncreaseSpeed(data.input, windowSize = data.windowSize)
        assertEquals(data.expected, result)
    }

    companion object {
        data class TestData(
            val input: List<Int>,
            val windowSize: Int = 1,
            val expected: Int
        )

        @JvmStatic
        @Suppress("unused")
        fun `depth increase data`() = listOf(
            TestData(
                input = listOf(1,2,3,4,5,6),
                expected = 5
            ),
            TestData(
                input = listOf(6,5,4,3,2,1),
                expected = 0
            ),
            TestData(
                input = listOf(1,1,1,1,1),
                expected = 0
            ),
            TestData(
                input = listOf(1,2,1,2,1),
                expected = 2
            ),
            TestData(
                input = listOf(1,2,3,4,5,6),
                windowSize = 2,
                expected = 4
            ),
            TestData(
                input = listOf(199,200,208,210,200,207,240,269,260,263),
                windowSize = 3,
                expected = 5
            )
        )
    }
}
