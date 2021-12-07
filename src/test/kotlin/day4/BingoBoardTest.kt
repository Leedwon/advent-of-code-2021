package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class BingoBoardTest {

    private val bingo = BingoBoard(values.map { BingoElement(value = it, marked = false) })

    @ParameterizedTest
    @MethodSource("bingo get test data provider")
    fun `test getting bingo values`(data: BingoGetTestData) {
        val result = bingo[data.x, data.y]

        assertEquals(data.expected, result.value)
    }

    @ParameterizedTest
    @MethodSource("bingo win test data provider")
    fun `test bingo won`(data: BingoWinTestData) {
        for (element in bingo) {
            if (element.value in data.markedValues) {
                element.marked = true
            }
        }

        assertEquals(data.expected, bingo.won)
    }

    companion object {
        data class BingoGetTestData(
            val x: Int,
            val y: Int,
            val expected: Int
        )

        data class BingoWinTestData(
            val markedValues: List<Int>,
            val expected: Boolean
        )

        val values = listOf(
            0, 1, 2, 3, 4,
            5, 6, 7, 8, 9,
            10, 11, 12, 13, 14,
            15, 16, 17, 18, 19,
            20, 21, 22, 23, 24
        )

        @JvmStatic
        @Suppress("unused")
        fun `bingo get test data provider`() = listOf(
            BingoGetTestData(x = 0, y = 0, expected = 0),
            BingoGetTestData(x = 1, y = 0, expected = 1),
            BingoGetTestData(x = 2, y = 0, expected = 2),
            BingoGetTestData(x = 3, y = 0, expected = 3),
            BingoGetTestData(x = 4, y = 0, expected = 4),
            BingoGetTestData(x = 0, y = 1, expected = 5),
            BingoGetTestData(x = 0, y = 2, expected = 10),
            BingoGetTestData(x = 0, y = 3, expected = 15),
            BingoGetTestData(x = 0, y = 4, expected = 20),
        )

        @JvmStatic
        @Suppress("unused")
        fun `bingo win test data provider`() = listOf(
            BingoWinTestData(
                markedValues = listOf(values[0], values[1], values[2], values[3], values[4]),
                expected = true
            ),
            BingoWinTestData(
                markedValues = listOf(values[0], values[5], values[10], values[15], values[20]),
                expected = true
            ),
            BingoWinTestData(
                markedValues = listOf(values[0], values[1], values[2], values[10], values[15], values[20]),
                expected = false
            ),
        )
    }
}