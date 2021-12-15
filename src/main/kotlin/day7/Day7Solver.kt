package day7

import util.DaySolver
import util.readFileLines

class Day7Solver(private val crabsAligner: CrabsAligner) : DaySolver {
    override val dayDescription: String = "Day 7"

    private val crabInitialPositions = readFileLines("/day7_input.txt")
        .first()
        .split(",")
        .map { it.toInt() }

    override fun solveFirstChallenge(): String {
        return crabsAligner.getCheapestAlignment(crabInitialPositions, incrementalEngines = false).toString()
    }

    override fun solveSecondChallenge(): String {
        return crabsAligner.getCheapestAlignment(crabInitialPositions, incrementalEngines = true).toString()
    }
}
