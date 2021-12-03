package day2

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private class FakeParser : SubmarineActionParser {
    private var count = 0
    private var actions: List<SubmarineAction> = emptyList()

    fun reset() {
        count = 0
        actions = emptyList()
    }

    fun setUp(actions: List<SubmarineAction>) {
        this.actions = actions
    }

    override fun parse(input: String): SubmarineAction {
        return actions[count++]
    }

}

internal class NewNavigatorTest {

    private lateinit var parser: FakeParser
    private lateinit var navigator: NewNavigator

    @BeforeEach
    fun setUp() {
        parser = FakeParser()
        navigator = NewNavigator(parser)
    }

    private fun NewNavigator.assertPosition(expected: SubmarinePosition) {
        assertEquals(expected, this.currentPosition)
    }

    @Test
    fun `test navigation`() {
        parser.setUp(actions)

        navigator.performActions(listOf("fake action"))
        navigator.assertPosition(
            SubmarinePosition(
                x = 5,
                depth = 0,
                aim = 0
            )
        )

        navigator.performActions(listOf("fake action"))
        navigator.assertPosition(
            SubmarinePosition(
                x = 5,
                depth = 0,
                aim = 5
            )
        )

        navigator.performActions(listOf("fake action"))
        navigator.assertPosition(
            SubmarinePosition(
                x = 13,
                depth = 40,
                aim = 5
            )
        )

        navigator.performActions(listOf("fake action"))
        navigator.assertPosition(
            SubmarinePosition(
                x = 13,
                depth = 40,
                aim = 2
            )
        )

        navigator.performActions(listOf("fake action"))
        navigator.assertPosition(
            SubmarinePosition(
                x = 13,
                depth = 40,
                aim = 10
            )
        )

        navigator.performActions(listOf("fake action"))
        navigator.assertPosition(
            SubmarinePosition(
                x = 15,
                depth = 60,
                aim = 10
            )
        )
    }

    companion object {
        val actions = listOf(
            SubmarineAction.Forward(5),
            SubmarineAction.Down(5),
            SubmarineAction.Forward(8),
            SubmarineAction.Up(3),
            SubmarineAction.Down(8),
            SubmarineAction.Forward(2),
        )
    }
}