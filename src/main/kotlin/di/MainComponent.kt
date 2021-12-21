package di

import util.DaySolver

object MainComponent {

    val solvers: List<DaySolver> = listOf(
        Day1Component.day1Solver,
        Day2Component.day2Solver,
        Day3Component.day3Solver,
        Day4Component.day4Solver,
        Day5Component.day5Solver,
        Day6Component.day6Solver,
        Day7Component.day7Solver,
        Day8Component.day8Solver,
        Day9Component.day9Solver,
        Day10Component.day10Solver
    )
}
