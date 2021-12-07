package day4

import util.readFileLines

class BingoDataProvider {

    private val sideSize = 5

    fun getBingoData(resourceName: String): BingoData {
        val lines = readFileLines(resourceName).filter { it.isNotEmpty() }

        return BingoData(
            bingoValues = parseBingoInput(lines.first()),
            bingoBoards = parseBingoBoards(lines.drop(1))
        )
    }

    private fun parseBingoInput(line: String): List<Int> {
        return line
            .split(",")
            .map { it.toInt() }
    }

    private fun parseBingoBoards(boardsLines: List<String>): List<BingoBoard> {
        return boardsLines.chunked(sideSize) { parseBingoBoard(it) }
    }

    private fun parseBingoBoard(boardLines: List<String>): BingoBoard {
        val values = boardLines
            .joinToString(separator = " ")
            .chunked(3) { it.filter { char -> char != ' ' }.toString().toInt() }
        return BingoBoard(values = values.map { BingoElement(value = it, marked = false) })
    }
}