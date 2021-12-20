package day9

private typealias LavaMap = List<List<Int>>
private typealias MutableLavaMap = List<MutableList<Int>>

private val LavaMap.width: Int
    get() = this.first().size

private val LavaMap.height: Int
    get() = this.size

class LavaTubesNavigator(private val lavaParser: LavaParser) {

    private data class LowPoint(
        val height: Int,
        val width: Int,
        val value: Int
    )

    private fun LavaMap.getLowPoints(): List<LowPoint> {
        val lowPoints = mutableListOf<LowPoint>()

        for (h in 0 until height) {
            for (w in 0 until width) {
                val leftIndex = (w - 1).takeIf { it >= 0 }
                val rightIndex = (w + 1).takeIf { it < width }
                val downIndex = (h + 1).takeIf { it < height }
                val upIndex = (h - 1).takeIf { it >= 0 }

                val element = this[h][w]
                val isLowerThanLeft = leftIndex == null || this[h][leftIndex] > element
                val isLowerThanRight = rightIndex == null || this[h][rightIndex] > element
                val isLowerThanDown = downIndex == null || this[downIndex][w] > element
                val isLowerThanUp = upIndex == null || this[upIndex][w] > element

                if (isLowerThanLeft && isLowerThanRight && isLowerThanUp && isLowerThanDown) {
                    lowPoints += LowPoint(height = h, width = w, value = element)
                }
            }
        }

        return lowPoints
    }

    private fun LavaMap.getBasinsSizes(lowPoints: List<LowPoint>): List<Int> {
        return lowPoints.map { getBasinSizeFor(it) }
    }

    private fun LavaMap.getBasinSizeFor(lowPoint: LowPoint): Int {
        val startingW = lowPoint.width
        val startingH = lowPoint.height
        val mutableLavaMap: MutableLavaMap = this.map { it.toMutableList() }
        mutableLavaMap[startingH][startingW] = 9 //mark as visited
        return 1 + mutableLavaMap.basinLeftScan(startingW, startingH) + mutableLavaMap.basinRightScan(startingW, startingH)
    }

    private fun MutableLavaMap.basinLeftScan(startingW: Int, startingH: Int): Int {
        var sum = 0
        for (i in startingW - 1 downTo 0) {
            if (this[startingH][i] == 9) break
            sum++
            this[startingH][i] = 9 //mark as visited to not end up in infinite loop
            sum += basinTopScan(i, startingH)
            sum += basinDownScan(i, startingH)
        }
        return sum
    }

    private fun MutableLavaMap.basinRightScan(startingW: Int, startingH: Int): Int {
        var sum = 0
        for (i in startingW + 1 until width) {
            if (this[startingH][i] == 9) break
            sum++
            this[startingH][i] = 9 //mark as visited to not end up in infinite loop
            sum += basinTopScan(i, startingH)
            sum += basinDownScan(i, startingH)
        }
        return sum
    }

    private fun MutableLavaMap.basinTopScan(startingW: Int, startingH: Int): Int {
        var sum = 0
        for (i in startingH - 1 downTo 0) {
            if (this[i][startingW] == 9) break
            sum++
            this[i][startingW] = 9 //mark as visited to not end up in infinite loop
            sum += basinLeftScan(startingW, i)
            sum += basinRightScan(startingW, i)
        }
        return sum
    }

    private fun MutableLavaMap.basinDownScan(startingW: Int, startingH: Int): Int {
        var sum = 0
        for (i in startingH + 1 until height) {
            if (this[i][startingW] == 9) break
            sum++
            this[i][startingW] = 9 //mark as visited to not end up in infinite loop
            sum += basinLeftScan(startingW, i)
            sum += basinRightScan(startingW, i)
        }
        return sum
    }

    fun calculateLowPointsRiskSum(input: List<String>): Int {
        val map = lavaParser.parseLines(input)
        return map.getLowPoints().map { it.value + 1 }.sum()
    }

    fun calculateBasins(input: List<String>): Int {
        val map = lavaParser.parseLines(input)
        val lowPoints = map.getLowPoints()
        return map.getBasinsSizes(lowPoints).sortedDescending().take(3).fold(1) { prev, curr -> prev * curr }
    }
}