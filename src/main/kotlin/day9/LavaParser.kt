package day9

class LavaParser {

    fun parseLines(lines: List<String>): List<List<Int>> {
        return lines.map { line -> line.map { Character.getNumericValue(it) } }
    }
}