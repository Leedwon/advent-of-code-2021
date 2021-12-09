package day5

import util.DaySolver

class Day5Solver(
    oceanLinesDataProvider: OceanLinesDataProvider,
    private val oceanLinesDetector: OceanLinesDetector
) : DaySolver {
    override val dayDescription: String = "day 5"

    private val oceanLines = oceanLinesDataProvider.getLines("/day5_input.txt")

    override fun solveFirstChallenge(): String {
        return oceanLinesDetector.countOverlappingLines(oceanLines, countDiagonals = false).toString()
    }

    override fun solveSecondChallenge(): String {
        return oceanLinesDetector.countOverlappingLines(oceanLines, countDiagonals = true).toString()
    }
}