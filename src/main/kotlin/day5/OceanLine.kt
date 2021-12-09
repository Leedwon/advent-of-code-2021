package day5

import java.lang.Math.abs

typealias Point = Pair<Int, Int>

val Point.x
    get() = this.first

val Point.y
    get() = this.second

data class OceanLine(
    val start: Point,
    val end: Point
) {
    val isHorizontal: Boolean
        get() = start.x == end.x

    val isVertical: Boolean
        get() = start.y == end.y

    val isAt45Degrees: Boolean
        get() {
            val xDiff = end.x - start.x
            val yDiff = end.y - start.y
            return when {
                yDiff == 0 -> xDiff == 0
                else -> abs(xDiff/yDiff) == 1
            }
        }
}