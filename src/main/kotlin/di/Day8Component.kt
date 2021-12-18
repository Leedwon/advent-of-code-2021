package di

import day8.Day8Solver
import day8.SevenSegmentsDisplayUtils

object Day8Component {

    private val sevenSegmentsDisplayUtils
        get() = SevenSegmentsDisplayUtils()

    val day8Solver: Day8Solver
        get() = Day8Solver(sevenSegmentsDisplayUtils)
}