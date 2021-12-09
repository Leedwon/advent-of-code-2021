package di

import day4.BingoDataProvider
import day4.BingoFinder
import day4.Day4Solver

object Day4Component {

    private val bingoDataProvider: BingoDataProvider
        get() = BingoDataProvider()

    private val bingoFinder: BingoFinder
        get() = BingoFinder()

    val day4Solver
        get() = Day4Solver(bingoDataProvider, bingoFinder)
}
