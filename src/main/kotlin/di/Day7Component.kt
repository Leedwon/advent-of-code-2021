package di

import day7.CrabsAligner
import day7.Day7Solver

object Day7Component {

    private val crabsAligner: CrabsAligner
        get() = CrabsAligner()

    val day7Solver: Day7Solver
        get() = Day7Solver(crabsAligner)
}
