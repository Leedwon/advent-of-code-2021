package day2

sealed class SubmarineAction {
    data class Forward(val value: Int) : SubmarineAction()
    data class Up(val value: Int) : SubmarineAction()
    data class Down(val value: Int) : SubmarineAction()
    object Unknown : SubmarineAction()
}