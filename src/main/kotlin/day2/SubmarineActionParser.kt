package day2

interface SubmarineActionParser {
    fun parse(input: String): SubmarineAction
}

class SubmarineActionParserImpl : SubmarineActionParser {
    override fun parse(input: String): SubmarineAction {
        val split = input.split(" ")
        if (split.size != 2) return SubmarineAction.Unknown

        val (name, value) = input.split(" ")
        val parsedValue = value.toIntOrNull() ?: return SubmarineAction.Unknown

        return when (name.lowercase()) {
            "forward" -> SubmarineAction.Forward(parsedValue)
            "up" -> SubmarineAction.Up(parsedValue)
            "down" -> SubmarineAction.Down(parsedValue)
            else -> SubmarineAction.Unknown
        }
    }
}
