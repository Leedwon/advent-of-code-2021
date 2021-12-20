package di

import day9.Day9Solver
import day9.LavaParser
import day9.LavaTubesNavigator

object Day9Component {

    private val lavaParser: LavaParser
        get() = LavaParser()

    private val lavaTubesNavigator: LavaTubesNavigator
        get() = LavaTubesNavigator(lavaParser)

    val day9Solver: Day9Solver
        get() = Day9Solver(lavaTubesNavigator)
}