package di

import day1.Day1Solver
import day1.SonarSweep

object Day1Component {

    private val sonarSweep: SonarSweep
        get() = SonarSweep()

    val day1Solver
        get() = Day1Solver(sonarSweep)
}
