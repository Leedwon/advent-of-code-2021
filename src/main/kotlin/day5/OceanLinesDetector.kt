package day5

class OceanLinesDetector {
    /**
     * @param overlapThreshold - how many lines have to overlap in one place for it to be counted
     */
    fun countOverlappingLines(oceanLines: List<OceanLine>, countDiagonals: Boolean, overlapThreshold: Int = 2): Int {
        val ocean = mutableMapOf<Point, Int>()
        ocean.fillWithLines(oceanLines, countDiagonals)

        return ocean.filterValues { it >= overlapThreshold }.count()
    }

    private fun MutableMap<Point, Int>.fillWithLines(oceanLines: List<OceanLine>, countDiagonals: Boolean) {
        for (line in oceanLines) {
            if (line.isHorizontal) {
                for (y in line.minY..line.maxY) {
                    val point = Point(line.start.x, y)
                    this[point] = 1 + (this[point] ?: 0)
                }
            }

            if (line.isVertical) {
                for (x in line.minX..line.maxX) {
                    val point = Point(x, line.start.y)
                    this[point] = 1 + (this[point] ?: 0)
                }
            }

            if (countDiagonals && line.isAt45Degrees) {
                val xIncrement = (line.end.x - line.start.x).coerceIn(-1..1)
                val yIncrement = (line.end.y - line.start.y).coerceIn(-1..1)

                var point = line.start
                this[point] = 1 + (this[point] ?: 0)
                while (point != line.end) {
                    point = Point(point.x + xIncrement, point.y + yIncrement)
                    this[point] = 1 + (this[point] ?: 0)
                }
            }
        }
    }

    private val OceanLine.minX: Int
        get() = minOf(start.x, end.x)

    private val OceanLine.maxX: Int
        get() = maxOf(start.x, end.x)


    private val OceanLine.minY: Int
        get() = minOf(start.y, end.y)

    private val OceanLine.maxY: Int
        get() = maxOf(start.y, end.y)
}
