package day6

import util.DaySolver
import util.readFileLines

class Day6Solver : DaySolver {
    override val dayDescription: String = "Day 6"

    private val fishes = readFileLines("/day6_input.txt")
        .first()
        .split(",")
        .map { it.toInt() }

    private val population = LanternfishPopulation(fishes.map(::Lanternfish))

    override fun solveFirstChallenge(): String {
        return population.calculatePopulationSizeAfter(80).toString()
    }

    override fun solveSecondChallenge(): String {
        return population.optimizedCalculatePosition(fishes, 256).toString()
    }
}
