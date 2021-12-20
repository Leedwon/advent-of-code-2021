package day9

import util.DaySolver
import util.readFileLines

class Day9Solver(private val lavaTubesNavigator: LavaTubesNavigator) : DaySolver {
    override val dayDescription: String = "Day 9"

    private val data = readFileLines("/day9_input.txt")

    override fun solveFirstChallenge(): String {
        return lavaTubesNavigator.calculateLowPointsRiskSum(data).toString()
    }

    override fun solveSecondChallenge(): String {
        return lavaTubesNavigator.calculateBasins(data).toString()
    }
}