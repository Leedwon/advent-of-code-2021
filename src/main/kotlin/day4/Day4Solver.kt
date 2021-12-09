package day4

import util.DaySolver

class Day4Solver(
    bingoDataProvider: BingoDataProvider,
    private val bingoFinder: BingoFinder
) : DaySolver {

    private val data = bingoDataProvider.getBingoData("/day4_input.txt")

    override val dayDescription: String
        get() = "Day 4"

    override fun solveFirstChallenge(): String {
        return bingoFinder.getWinnerScore(data).toString()
    }

    override fun solveSecondChallenge(): String {
        return bingoFinder.getLoserScore(data).toString()
    }
}