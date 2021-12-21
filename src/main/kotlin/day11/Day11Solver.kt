package day11

import util.DaySolver
import util.readFileLines

class Day11Solver(private val octopusFlashCounter: OctopusFlashCounter) : DaySolver {
    override val dayDescription: String
        get() = "Day 11"

    private val input = readFileLines("/day11_input.txt").map { it.map { Character.getNumericValue(it) } }

    override fun solveFirstChallenge(): String {
        return octopusFlashCounter.countOctopusFlashesAfter(input, 100).toString()
    }

    override fun solveSecondChallenge(): String {
        return octopusFlashCounter.getFirstSynchronizedFlashStep(input).toString()
    }
}