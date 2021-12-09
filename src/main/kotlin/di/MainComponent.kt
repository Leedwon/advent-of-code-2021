package di

import util.DaySolver

object MainComponent {

    val solvers: List<DaySolver> = listOf(
        Day1Component.day1Solver,
        Day2Component.day2Solver,
        Day3Component.day3Solver,
        Day4Component.day4Solver
    )
}
