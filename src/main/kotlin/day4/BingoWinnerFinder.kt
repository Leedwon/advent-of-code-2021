package day4

import java.lang.IllegalStateException

class BingoWinnerFinder {

    fun getWinnerScore(bingoData: BingoData): Int {
        val (values, boards) = bingoData

        for (value in values) {
            boards.markIfHit(value)
            val winner = boards.firstOrNull { it.won }
            if (winner != null) {
                return winner.calculateScore(value)
            }
        }
        throw IllegalStateException("winner could not be find")
    }

    private fun BingoBoard.calculateScore(lastValue: Int): Int {
        return values
            .filter { !it.marked }
            .sumOf { it.value } * lastValue
    }

    private fun BingoBoard.markIfHit(value: Int) {
        for (element in this.values) {
            if (element.value == value) {
                element.marked = true
            }
        }
    }

    private fun List<BingoBoard>.markIfHit(value: Int) {
        this.forEach { it.markIfHit(value) }
    }

}