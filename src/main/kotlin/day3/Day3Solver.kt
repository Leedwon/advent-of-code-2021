package day3

import util.DaySolver
import util.readFileLines

class Day3Solver(private val binaryDiagnoses: BinaryDiagnoses) : DaySolver {
    override val dayDescription: String
        get() = "Day 3"

    override fun solveFirstChallenge(): String {
        val input = readFileLines("/day3_input.txt")
        val bitSize = input[0].length
        val bits = input.map { it.toInt(2) }
        return binaryDiagnoses.diagnosePowerConsumption(bits, bitSize).toString()
    }

    override fun solveSecondChallenge(): String {
        val input = readFileLines("/day3_input.txt")
        val bitSize = input[0].length
        val bits = input.map { it.toInt(2) }
        return binaryDiagnoses.diagnoseLifeSupportRating(bits, bitSize).toString()
    }
}