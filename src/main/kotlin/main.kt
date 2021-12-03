import di.MainComponent
import util.DaySolver

private fun DaySolver.buildText(): String = buildString {
    appendLine("$dayDescription challenge 1 result = ${solveFirstChallenge()}")
    appendLine("$dayDescription challenge 2 result = ${solveSecondChallenge()}")
}

fun main(args: Array<String>) {
    println(
        buildString {
            for (solver in MainComponent.solvers) {
                append(solver.buildText())
            }
        }
    )
}
