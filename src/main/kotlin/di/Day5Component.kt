package di

import day5.Day5Solver
import day5.OceanLinesDataProvider
import day5.OceanLinesDetector

object Day5Component {

    private val oceanLinesDataProvider: OceanLinesDataProvider
        get() = OceanLinesDataProvider()

    private val oceanLinesDetector: OceanLinesDetector
        get() = OceanLinesDetector()

    val day5Solver: Day5Solver
        get() = Day5Solver(oceanLinesDataProvider, oceanLinesDetector)
}