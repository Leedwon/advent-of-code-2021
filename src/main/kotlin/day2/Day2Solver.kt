package day2

import util.DaySolver
import util.readFileLines

class Day2Solver(
    private val oldNavigator: SubmarineNavigator,
    private val newNavigator: SubmarineNavigator
) : DaySolver {
    override val dayDescription: String
        get() = "Day 2"

    override fun solveFirstChallenge(): String {
        val input = readFileLines("/day2_input.txt")
        oldNavigator.performActions(input)
        return oldNavigator.currentPosition.course.toString()
    }

    override fun solveSecondChallenge(): String {
        val input = readFileLines("/day2_input.txt")
        newNavigator.performActions(input)
        return newNavigator.currentPosition.course.toString()
    }
}