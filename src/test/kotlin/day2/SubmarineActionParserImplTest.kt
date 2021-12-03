package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class SubmarineActionParserImplTest {

    private val parser = SubmarineActionParserImpl()

    @ParameterizedTest
    @MethodSource("actions data source")
    fun `should parse actions`(data: ActionTestData) {
        val result = parser.parse(data.input)
        assertEquals(data.expected, result)
    }

    companion object {
        data class ActionTestData(
            val input: String,
            val expected: SubmarineAction
        )

        @JvmStatic
        @Suppress("unused")
        fun `actions data source`() = listOf(
            ActionTestData(
                input = "forward 3",
                expected = SubmarineAction.Forward(3)
            ),
            ActionTestData(
                input = "down 33",
                expected = SubmarineAction.Down(33)
            ),
            ActionTestData(
                input = "up 22",
                expected = SubmarineAction.Up(22)
            ),
            ActionTestData(
                input = "back 4",
                expected = SubmarineAction.Unknown
            ),
            ActionTestData(
                input = "random",
                expected = SubmarineAction.Unknown
            ),
            ActionTestData(
                input = "forward xdd",
                expected = SubmarineAction.Unknown
            ),
        )
    }
}