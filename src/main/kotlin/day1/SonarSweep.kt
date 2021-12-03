package day1

class SonarSweep {
    fun calculateDepthIncreaseSpeed(input: List<Int>): Int {
        return input.zipWithNext { first, second -> if(second > first) 1 else 0 }.sum()
    }
}