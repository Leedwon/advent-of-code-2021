package di

import day2.*

object Day2Component {

    private val submarineActionParser: SubmarineActionParser
        get() = SubmarineActionParserImpl()

    private val submarineOldNavigator: SubmarineNavigator
        get() = OldNavigator(submarineActionParser)

    private val submarineNewNavigator: SubmarineNavigator
        get() = NewNavigator(submarineActionParser)

    val day2Solver
        get() = Day2Solver(
            oldNavigator = submarineOldNavigator,
            newNavigator = submarineNewNavigator
        )
}
