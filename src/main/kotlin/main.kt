import day1.SonarSweep
import util.getFileIntContent

fun main(args: Array<String>) {
    val sonarSweep = SonarSweep()
    val depthIncreaseSpeed = sonarSweep.calculateDepthIncreaseSpeed(getFileIntContent("/day1_challenge_1_input.txt"))
    println(
        buildString {
            appendLine("day1 task1 result = $depthIncreaseSpeed")
        }
    )
}