package day4

import util.DaySolver

class Day4Solver(
    private val bingoDataProvider: BingoDataProvider,
    private val bingoWinnerFinder: BingoWinnerFinder
) : DaySolver {
    override val dayDescription: String
        get() = "Day 4"

    override fun solveFirstChallenge(): String {
        val data = bingoDataProvider.getBingoData("/day4_input.txt")
        return bingoWinnerFinder.getWinnerScore(data).toString()
    }

    override fun solveSecondChallenge(): String {
        return ""
    }
}