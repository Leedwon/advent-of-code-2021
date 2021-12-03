package day1

import util.DaySolver
import util.getFileIntContent

class Day1Solver(private val sonarSweep: SonarSweep) : DaySolver {
    override val dayDescription: String
        get() = "Day 1"

    override fun solveFirstChallenge(): String {
        val input = getFileIntContent("/day1_input.txt")
        return sonarSweep.calculateDepthIncreaseSpeed(input).toString()
    }

    override fun solveSecondChallenge(): String {
        val input = getFileIntContent("/day1_input.txt")
        return sonarSweep.calculateDepthIncreaseSpeed(
            input = input,
            windowSize = 3
        ).toString()
    }

}