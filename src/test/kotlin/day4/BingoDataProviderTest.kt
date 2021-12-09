package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BingoDataProviderTest {

    private val provider = BingoDataProvider()

    @Test
    fun `should provide correct data`() {
        val expected = BingoData(
            bingoValues = listOf(10, 80, 6, 69, 22, 99, 63),
            bingoBoards = listOf(
                BingoBoard(
                    values = listOf(
                        3, 82, 18, 50, 90,
                        16, 37, 52, 67, 28,
                        30, 54, 80, 11, 10,
                        60, 79, 7, 65, 58,
                        76, 83, 38, 51, 1,
                    ).map { BingoElement(it, false) }
                ),
                BingoBoard(
                    values = listOf(
                        83, 63, 60, 88, 98,
                        70, 87, 5, 99, 14,
                        85, 3, 11, 16, 33,
                        72, 69, 97, 36, 49,
                        26, 17, 58, 13, 2
                    ).map { BingoElement(it, false) }
                )
            )
        )

        val actual = provider.getBingoData("/day4_test_input.txt")
        assertEquals(expected, actual)
    }
}