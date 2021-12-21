package di

import day10.Day10Solver
import day10.SyntaxChecker

object Day10Component {

    private val syntaxChecker
        get() = SyntaxChecker()

    val day10Solver: Day10Solver
        get() = Day10Solver(syntaxChecker)
}