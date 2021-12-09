package day5

import util.readFileLines

class OceanLinesDataProvider {

    fun getLines(resourceName: String): List<OceanLine> = readFileLines(resourceName).map { parseLine(it) }

    private fun parseLine(line: String): OceanLine {
        val (start, end) = line.split("->")
        return OceanLine(
            start = parsePoint(start.trim()),
            end = parsePoint(end.trim())
        )
    }

    private fun parsePoint(input: String): Point {
        val (x, y) = input.split(",").map { it.toInt() }
        return Point(x, y)
    }
}
