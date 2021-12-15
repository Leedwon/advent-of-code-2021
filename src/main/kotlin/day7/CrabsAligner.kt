package day7

import java.lang.Math.abs

class CrabsAligner {

    fun getCheapestAlignment(initialCrabsPosition: List<Int>, incrementalEngines: Boolean): Int {
        var cheapest = Int.MAX_VALUE

        val min = initialCrabsPosition.minOrNull() ?: 0
        val max = initialCrabsPosition.maxOrNull() ?: 0
        val possiblePositions = (min..max)

        for (alignAt in possiblePositions) {
            var cost = 0
            for (crab in initialCrabsPosition) {
                cost += createCostOfMove(from = crab, to = alignAt, incrementalEngines = incrementalEngines)
                if (cost > cheapest) break
            }
            if (cost < cheapest) {
                cheapest = cost
            }
        }

        return cheapest
    }

    private fun createCostOfMove(from: Int, to: Int, incrementalEngines: Boolean): Int {
        return when (incrementalEngines) {
            true -> {
                val size = abs(from - to)
                (0..size).sum()
            }
            false -> abs(from - to)
        }
    }
}