package day2

class OldNavigator(private val submarineActionParser: SubmarineActionParser) : SubmarineNavigator {
    private var position = SubmarinePosition(x = 0, depth = 0, aim = 0)
    override val currentPosition: SubmarinePosition
        get() = position

    override fun performActions(actions: List<String>) {
        actions
            .map(submarineActionParser::parse)
            .forEach(::handleAction)
    }

    fun handleAction(action: SubmarineAction) {
        val currentPosition = position
        when (action) {
            is SubmarineAction.Forward -> position = currentPosition.copy(x = currentPosition.x + action.value)
            is SubmarineAction.Down -> position = currentPosition.copy(depth = currentPosition.depth + action.value)
            is SubmarineAction.Up -> position = currentPosition.copy(depth = currentPosition.depth - action.value)
            SubmarineAction.Unknown -> {
                //noop
            }
        }
    }
}