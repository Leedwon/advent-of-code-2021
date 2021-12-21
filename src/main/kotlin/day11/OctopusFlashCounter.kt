package day11

private data class Octopus(
    val powerLevel: Int,
    val flashed: Boolean
)

private class OctopusStateMachine(
    initialState: List<List<Int>>
) {
    private val width = initialState.first().size
    private val height = initialState.size

    private fun log() {
        for (x in 0 until width) {
            for (y in 0 until height) {
                val value = internalState[(y to x).toIndex()]
                print(if (value.flashed) "x" else if (value.shouldFlash) "i" else value.powerLevel)
            }
            print("\n")
        }
        println()
        println()
    }

    private var internalState: List<Octopus> = initialState.flatten().map { Octopus(it, false) }
    private var step = 0
    var flashesCount = 0
        private set
    var synchronizedFlashesSteps = emptyList<Int>()
        private set

    private fun Int.toCoords(): Pair<Int, Int> {
        val x = this % height
        val y = this / width
        return x to y
    }

    private fun Pair<Int, Int>.toIndex() = this.first + this.second * width

    private val Octopus.shouldFlash: Boolean
        get() = !this.flashed && this.powerLevel > 9

    fun moveToNextStep() {
        step++
        increaseEnergyLevel()
        performFlashes()
        if (internalState.all { it.flashed }) {
            synchronizedFlashesSteps = synchronizedFlashesSteps + step
        }
        resetFlashed()
    }

    private fun increaseEnergyLevel() {
        internalState = internalState.map { it.copy(powerLevel = it.powerLevel + 1) }
    }

    private fun performFlashes() {
        val flashedAt = internalState.mapIndexedNotNull { index, octopus -> index.takeIf { octopus.shouldFlash } }

        flashesCount += flashedAt.size

        markFlashed(flashedAt)
        increaseEnergyAfterFlashes(flashedAt)

        if (internalState.any { it.shouldFlash }) {
            performFlashes()
        }
    }

    private fun resetFlashed() {
        internalState = internalState.map { octopus ->
            if (octopus.flashed) Octopus(0, false) else octopus
        }
    }

    private fun markFlashed(indexes: List<Int>) {
        internalState = internalState.mapIndexed { index, octopus ->
            if (index in indexes) octopus.copy(flashed = true) else octopus
        }
    }

    private fun increaseEnergyAfterFlashes(flashedIndexes: List<Int>) {
        flashedIndexes.forEach { index ->
            val adjacentIndexes = getAdjacentIndexes(index)
            internalState = internalState.mapIndexed { i, octopus ->
                if (i in adjacentIndexes && !octopus.flashed) {
                    octopus.copy(powerLevel = octopus.powerLevel + 1)
                } else {
                    octopus
                }
            }
        }
    }

    private fun getAdjacentIndexes(index: Int): List<Int> {
        val (x, y) = index.toCoords()

        return listOfNotNull(
            (x + 1 to y).toIndex().takeIf { x + 1 in 0 until width && y in 0 until height },
            (x + 1 to y + 1).toIndex().takeIf { x + 1 in 0 until width && y + 1 in 0 until height },
            (x to y + 1).toIndex().takeIf { x in 0 until width && y + 1 in 0 until height },
            (x - 1 to y + 1).toIndex().takeIf { x - 1 in 0 until width && y + 1 in 0 until height },
            (x - 1 to y).toIndex().takeIf { x - 1 in 0 until width && y in 0 until height },
            (x - 1 to y - 1).toIndex().takeIf { x - 1 in 0 until width && y - 1 in 0 until height },
            (x to y - 1).toIndex().takeIf { x in 0 until width && y - 1 in 0 until height },
            (x + 1 to y - 1).toIndex().takeIf { x + 1 in 0 until width && y - 1 in 0 until height },
        )

    }
}

class OctopusFlashCounter {
    fun countOctopusFlashesAfter(initialState: List<List<Int>>, steps: Int): Int {
        val stateMachine = OctopusStateMachine(initialState)

        repeat(steps) {
            stateMachine.moveToNextStep()
        }

        return stateMachine.flashesCount
    }

    fun getFirstSynchronizedFlashStep(initialState: List<List<Int>>): Int {
        val stateMachine = OctopusStateMachine(initialState)

        while (stateMachine.synchronizedFlashesSteps.isEmpty()) {
            stateMachine.moveToNextStep()
        }

        return stateMachine.synchronizedFlashesSteps.first()
    }
}