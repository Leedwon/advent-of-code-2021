package day8

class SevenSegmentsDisplayUtils {

    private fun splitToInputAndOutput(value: String): List<String> = value.split("|")

    private fun splitToDisplayedDigits(value: String): List<String> = value.split(" ").filter { it.isNotEmpty() }

    /**
     * decodes wires that are represented as (a-g) to seven segment display:
     *    000
     *  1     2
     *  1     2
     *    333
     *  4     5
     *  4     5
     *    666
     * @returns map of segment to corresponding letter
     */

    private fun decodeDisplay(values: List<String>): Map<Int, String> {
        val result = mutableMapOf<Int, String>()

        val one = values.first { it.length == SevenSegmentsDisplayElement.One.wiresUsed }
        val four = values.first { it.length == SevenSegmentsDisplayElement.Four.wiresUsed }
        val seven = values.first { it.length == SevenSegmentsDisplayElement.Seven.wiresUsed }
        val eight = values.first { it.length == SevenSegmentsDisplayElement.Eight.wiresUsed }

        val segment0 = seven.filter { it !in one }
        result[0] = segment0

        val sixSegmentNumbers = values.filter { it.length == 6 }
        val candidates =
            sixSegmentNumbers
                .map { number -> number.filter { char -> !sixSegmentNumbers.all { it.contains(char) } } }
                .flatMap { it.toList() } //chars from string
                .toSet()
                .map { it.toString() }

        val segment2 = candidates.first { it in one }
        result[2] = segment2

        val segment5 = one.first { it.toString() !in result.values }.toString()
        result[5] = segment5

        val five = values.filter { it.length == 5 }.first { !it.contains(result[2].toString()) }
        val modifiedFive = five.replace(result[0]!!, "")
        val modifiedFour = four.replace(result[2]!!, "")

        val segment6 = modifiedFive.first { it !in modifiedFour }
        result[6] = segment6.toString()

        val three = values.first { it.length == 5 && it != five }

        val segment3 = five.first { it in three && it.toString() !in result.values }
        result[3] = segment3.toString()

        val segment1 = five.first { it.toString() !in result.values }
        result[1] = segment1.toString()

        val segment4 = eight.first { it.toString() !in result.values }
        result[4] = segment4.toString()

        check(result.values.toSet().size == 7) { "parsing failed for $values" }
        return result
    }

    private fun calculateOutputSum(value: String): Int {
        val (input, output) = splitToInputAndOutput(value)
        val merged = splitToDisplayedDigits(input + output)

        val decodedDisplay = decodeDisplay(merged)

        return splitToDisplayedDigits(output)
            .map { str -> str.map { decodedDisplay.findKeyForValue(it.toString()) } }
            .map(::getNumberForSegments)
            .joinToString(separator = "") { it.toString() }
            .toInt()
    }

    fun calculateOutputsSum(values: List<String>): Int =
        values.map { calculateOutputSum(it) }.sum()

    private fun Map<Int, String>.findKeyForValue(value: String): Int {
        return keys.first { get(it) == value }
    }

    private fun getNumberForSegments(segments: List<Int>): Int {
        return when {
            segments.containsExactly(listOf(0, 1, 2, 4, 5, 6)) -> 0
            segments.containsExactly(listOf(2, 5)) -> 1
            segments.containsExactly(listOf(0, 2, 3, 4, 6)) -> 2
            segments.containsExactly(listOf(0, 2, 3, 5, 6)) -> 3
            segments.containsExactly(listOf(1, 3, 2, 5)) -> 4
            segments.containsExactly(listOf(0, 1, 3, 5, 6)) -> 5
            segments.containsExactly(listOf(0, 1, 3, 4, 5, 6)) -> 6
            segments.containsExactly(listOf(0, 2, 5)) -> 7
            segments.containsExactly(listOf(0, 1, 2, 3, 4, 5, 6)) -> 8
            segments.containsExactly(listOf(0, 1, 2, 3, 5, 6)) -> 9
            else -> error("unknown segments")
        }
    }

    private fun List<Int>.containsExactly(other: List<Int>): Boolean {
        return this.containsAll(other) && this.size == other.size
    }

    fun countUniqueOutputElements(values: List<String>): Int =
        values
            .map(::countUniqueOutputElements)
            .sum()

    private fun countUniqueOutputElements(value: String): Int {
        val (input, output) = splitToInputAndOutput(value)
        val displayedDigits = splitToDisplayedDigits(output)

        return displayedDigits.filter { it.length in SevenSegmentsDisplayElement.uniqueElements.map { element -> element.wiresUsed } }.size
    }
}
