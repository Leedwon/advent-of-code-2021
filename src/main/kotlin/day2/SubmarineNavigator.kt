package day2

interface SubmarineNavigator {
    val currentPosition: SubmarinePosition
    fun performActions(actions: List<String>)
}