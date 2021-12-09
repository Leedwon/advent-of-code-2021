package di

import day3.BinaryDiagnoses
import day3.Day3Solver

object Day3Component {

    private val binaryDiagnoses: BinaryDiagnoses
        get() = BinaryDiagnoses()

    val day3Solver
        get() = Day3Solver(
            binaryDiagnoses = binaryDiagnoses
        )
}
