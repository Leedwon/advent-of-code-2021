package day10

import java.util.*

class SyntaxChecker {

    private val autocompletionMultiplyFactor = 5L

    private fun getErrorPointsFor(symbol: String): Int = when (symbol) {
        ")" -> 3
        "]" -> 57
        "}" -> 1197
        ">" -> 25137
        else -> error("unsupported symbol $symbol")
    }

    private fun getAutocompletionPointsFor(symbol: String): Int = when (symbol) {
        ")" -> 1
        "]" -> 2
        "}" -> 3
        ">" -> 4
        else -> error("unsupported symbol $symbol")
    }

    fun getFirstSyntaxErrorsScore(lines: List<String>): Int {
        return lines
            .mapNotNull(::getFirstSyntaxErrorSymbolOrNull)
            .map(::getErrorPointsFor)
            .sum()
    }

    fun getAutocompletionScore(lines: List<String>): Long {
        val scores = lines
            .mapNotNull(::calculateAutocompletionScoreForLineOrNull)
            .sorted()
        return scores[scores.size / 2]
    }

    /**
     * calculates autocompletion sum it is optimized to drop error lines on the fly to not filter and then calculate
     * @return autocompletion score or null if line is corrupted
     */
    private fun calculateAutocompletionScoreForLineOrNull(line: String): Long? {
        val queue: Deque<Char> = LinkedList()

        for (symbol in line) {
            when (symbol) {
                '(', '[', '{', '<' -> queue.add(symbol)
                ')', ']', '}', '>' -> if (queue.removeLast() != getOpeningSymbolFor(symbol)) return null
                else -> error("unsupported symbol $symbol")
            }
        }

        return queue
            .reversed()
            .fold(0L) { current, symbol ->
                val pointsForSymbol = getAutocompletionPointsFor(getClosingSymbolFor(symbol).toString())
                current * autocompletionMultiplyFactor + pointsForSymbol
            }
    }

    private fun getFirstSyntaxErrorSymbolOrNull(line: String): String? {
        val queue: Deque<Char> = LinkedList()

        for (symbol in line) {
            when (symbol) {
                '(', '[', '{', '<' -> queue.add(symbol)
                ')', ']', '}', '>' -> if (queue.removeLast() != getOpeningSymbolFor(symbol)) return symbol.toString()
                else -> error("unsupported symbol $symbol")
            }
        }
        return null
    }

    private fun getOpeningSymbolFor(symbol: Char) = when (symbol) {
        ')' -> '('
        ']' -> '['
        '}' -> '{'
        '>' -> '<'
        else -> error("unsupported symbol $symbol")
    }

    private fun getClosingSymbolFor(symbol: Char) = when (symbol) {
        '(' -> ')'
        '[' -> ']'
        '{' -> '}'
        '<' -> '>'
        else -> error("unsupported symbol $symbol")
    }
}