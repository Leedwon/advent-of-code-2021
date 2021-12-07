package day4

data class BingoBoard(
    val values: List<BingoElement>
) {
    private val sideSize = 5
    private val expectedSize = sideSize * sideSize

    val won: Boolean
        get() = checkWinCondition()

    init {
        check(values.size == expectedSize) { "Bingo board must contain exactly $expectedSize elements" }
    }

    operator fun get(x: Int, y: Int): BingoElement = values[y * sideSize + x]

    private fun checkWinCondition(): Boolean {
        for (i in (0 until sideSize)) {
            var rowCount = 0
            var columnCount = 0
            for (j in (0 until sideSize)) {
                if (get(i, j).marked) rowCount++
                if (get(j, i).marked) columnCount++

            }
            if (columnCount == sideSize || rowCount == sideSize) return true
        }
        return false
    }
}