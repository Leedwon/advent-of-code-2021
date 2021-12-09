package day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class OceanLinesDataProviderTest {

    private val linesProvider = OceanLinesDataProvider()

    @Test
    fun `should provide correct data`() {
        val actual = linesProvider.getLines("/day5_test_input.txt")
        assertEquals(expected, actual)
    }

    private companion object {
        val expected = listOf(
            OceanLine(start = Point(0, 9), end = Point(5, 9)),
            OceanLine(start = Point(8, 0), end = Point(0, 8)),
            OceanLine(start = Point(9, 4), end = Point(3, 4)),
            OceanLine(start = Point(2, 2), end = Point(2, 1)),
            OceanLine(start = Point(7, 0), end = Point(7, 4)),
            OceanLine(start = Point(6, 4), end = Point(2, 0)),
            OceanLine(start = Point(0, 9), end = Point(2, 9)),
            OceanLine(start = Point(3, 4), end = Point(1, 4)),
            OceanLine(start = Point(0, 0), end = Point(8, 8)),
            OceanLine(start = Point(5, 5), end = Point(8, 2)),
        )
    }

}