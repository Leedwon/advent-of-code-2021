package di

import day1.Day1Solver
import day1.SonarSweep
import day2.*
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

    val solvers: List<DaySolver> = listOf(
        day1Solver,
        day2Solver
    )
}
