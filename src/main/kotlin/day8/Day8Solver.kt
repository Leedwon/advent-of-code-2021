package day8

import util.DaySolver
import util.readFileLines

class Day8Solver(private val sevenSegmentsDisplayUtils: SevenSegmentsDisplayUtils) : DaySolver{
    override val dayDescription: String
        get() = "Day 8"

    private val lines = readFileLines("/day8_input.txt")

    override fun solveFirstChallenge(): String {
        return sevenSegmentsDisplayUtils.countUniqueOutputElements(lines).toString()
    }

    override fun solveSecondChallenge(): String {
        return sevenSegmentsDisplayUtils.calculateOutputsSum(lines).toString()
    }
}