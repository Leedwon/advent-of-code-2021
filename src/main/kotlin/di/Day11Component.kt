package di

import day11.Day11Solver
import day11.OctopusFlashCounter

object Day11Component {

    private val octopusFlashCounter
        get() = OctopusFlashCounter()

    val day11Solver: Day11Solver
        get() = Day11Solver(octopusFlashCounter)
}