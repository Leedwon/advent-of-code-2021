package day4

import java.lang.IllegalStateException

class BingoFinder {

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

    fun getLoserScore(bingoData: BingoData): Int {
        val (values, boards) = bingoData

        var boardsInGame = boards
        var lastValue = 0

        for (value in values) {
            if (boardsInGame.size == 1 && boardsInGame.first().won) break
            boardsInGame = boardsInGame.filter { !it.won }
            lastValue = value
            boards.markIfHit(value)
        }
        return boardsInGame.first().calculateScore(lastValue)
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