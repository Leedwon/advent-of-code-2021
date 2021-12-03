package day2

class NewNavigator(private val submarineActionParser: SubmarineActionParser) : SubmarineNavigator {
    private var position = SubmarinePosition(x = 0, depth = 0, aim = 0)
    override val currentPosition: SubmarinePosition
        get() = position

    override fun performActions(actions: List<String>) {
        actions
            .map(submarineActionParser::parse)
            .forEach(::handleAction)
    }

    private fun handleAction(action: SubmarineAction) {
        when (action) {
            is SubmarineAction.Forward -> moveForward(action.value)
            is SubmarineAction.Down -> moveDown(action.value)
            is SubmarineAction.Up -> moveUp(action.value)
            SubmarineAction.Unknown -> {
                //noop
            }
        }
    }

    private fun moveForward(value: Int) {
        val pos = position
        position = pos.copy(x = pos.x + value, depth = pos.depth + pos.aim * value)
    }

    private fun moveDown(value: Int) {
        val pos = position
        position = pos.copy(aim = pos.aim + value)
    }

    private fun moveUp(value: Int) {
        val pos = position
        position = pos.copy(aim = pos.aim - value)
    }
}