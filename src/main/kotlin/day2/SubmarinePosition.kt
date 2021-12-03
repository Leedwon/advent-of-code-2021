package day2

data class SubmarinePosition(
    val x: Int,
    val depth: Int,
    val aim: Int
) {
    val course: Int
        get() = x * depth
}