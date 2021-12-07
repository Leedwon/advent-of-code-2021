package di

import day1.Day1Solver
import day1.SonarSweep
import day2.*
import day3.BinaryDiagnoses
import day3.Day3Solver
import day4.BingoDataProvider
import day4.BingoWinnerFinder
import day4.Day4Solver
import util.DaySolver

object MainComponent {

    private val sonarSweep: SonarSweep
        get() = SonarSweep()

    private val day1Solver
        get() = Day1Solver(sonarSweep)

    private val submarineActionParser: SubmarineActionParser
        get() = SubmarineActionParserImpl()

    private val submarineOldNavigator: SubmarineNavigator
        get() = OldNavigator(submarineActionParser)

    private val submarineNewNavigator: SubmarineNavigator
        get() = NewNavigator(submarineActionParser)

    private val day2Solver
        get() = Day2Solver(
            oldNavigator = submarineOldNavigator,
            newNavigator = submarineNewNavigator
        )

    private val binaryDiagnoses: BinaryDiagnoses
        get() = BinaryDiagnoses()

    private val day3Solver
        get() = Day3Solver(
            binaryDiagnoses = binaryDiagnoses
        )

    private val bingoDataProvider: BingoDataProvider
        get() = BingoDataProvider()

    private val bingoWinnerFinder: BingoWinnerFinder
        get() = BingoWinnerFinder()

    private val day4Solver
        get() = Day4Solver(bingoDataProvider, bingoWinnerFinder)

    val solvers: List<DaySolver> = listOf(
        day1Solver,
        day2Solver,
        day3Solver,
        day4Solver
    )
}
