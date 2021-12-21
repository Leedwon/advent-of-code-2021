package day10

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import util.readFileLines

internal class SyntaxCheckerTest {

    private val sut = SyntaxChecker()

    @Test
    fun `should correctly calculate first errors score`() {
        val lines = readFileLines("/day10_test_input.txt")

        val actual = sut.getFirstSyntaxErrorsScore(lines)

        assertEquals(26397, actual)
    }

    @Test
    fun `should correctly calculate autocompletion score`() {
        val lines = readFileLines("/day10_test_input.txt")

        val actual = sut.getAutocompletionScore(lines)

        assertEquals(288957, actual)
    }
}