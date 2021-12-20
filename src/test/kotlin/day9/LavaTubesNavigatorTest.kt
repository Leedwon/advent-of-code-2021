package day9

import org.junit.jupiter.api.Test
import util.readFileLines
import kotlin.test.assertEquals

internal class LavaTubesNavigatorTest {

    private val lavaParser = LavaParser()
    private val sut = LavaTubesNavigator(lavaParser)

    @Test
    fun `should correctly calculated low points risk sum`() {
        val input = readFileLines("/day9_test_input.txt")

        val actual = sut.calculateLowPointsRiskSum(input)

        assertEquals(15, actual)
    }

    @Test
    fun `should correctly calculate basins`() {
        val input = readFileLines("/day9_test_input.txt")

        val actual = sut.calculateBasins(input)

        assertEquals(1134, actual)
    }
}