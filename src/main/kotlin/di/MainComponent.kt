package di

import day1.Day1Solver
import day1.SonarSweep
import util.DaySolver

object MainComponent {

    private val sonarSweep: SonarSweep
        get() = SonarSweep()

    private val day1Solver
        get() = Day1Solver(sonarSweep)

    val solvers: List<DaySolver> = listOf(
        day1Solver
    )
}
