package day1

class SonarSweep {

    private fun List<Int>.windowed(windowSize: Int) : List<List<Int>> {
        require(windowSize <= this.size) { "window size can't exceed list size" }
        val result = mutableListOf<List<Int>>()
        for (index in 0..lastIndex) {
            if (index + windowSize - 1 <= lastIndex) {
                result.add(List(windowSize) { get(index + it) })
            }
        }
        return result
    }

    fun calculateDepthIncreaseSpeed(input: List<Int>, windowSize: Int = 1): Int {
        return input
            .windowed(windowSize = windowSize) //custom impl is written just for fun feel free to replace with probably better one from Collections.kt
            .zipWithNext { first, second -> if (second.sum() > first.sum()) 1 else 0 }.sum()
    }
}
