package day10

import util.DaySolver
import util.readFileLines

class Day10Solver(private val syntaxChecker: SyntaxChecker) : DaySolver {
    override val dayDescription: String
        get() = "Day 10"

    private val lines = readFileLines("/day10_input.txt")

    override fun solveFirstChallenge(): String {
        return syntaxChecker.getFirstSyntaxErrorsScore(lines).toString()
    }

    override fun solveSecondChallenge(): String {
        return syntaxChecker.getAutocompletionScore(lines).toString()
    }
}