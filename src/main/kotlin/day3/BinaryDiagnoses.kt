package day3

class BinaryDiagnoses {

    fun diagnosePowerConsumption(input: List<Int>, bitsSize: Int): UInt {
        var gamma = 0U
        for (i in bitsSize downTo 1) {
            val bit = input.getMostCommonBitAtPosition(i).toUInt()
            gamma = gamma.shl(1)
            gamma += bit
        }
        val totalMask = createMaskFor(bitsSize).toUInt()
        return gamma * gamma.inv().and(totalMask)
    }

    fun diagnoseLifeSupportRating(input: List<Int>, bitsSize: Int): Int {
        val oxygen = diagnoseOxygen(input, bitsSize)
        val co2 = diagnoseCO2(input, bitsSize)
        return oxygen * co2
    }

    private fun diagnoseOxygen(input: List<Int>, bitsSize: Int): Int {
        var candidates = input
        var bitPosition = bitsSize

        while (candidates.size != 1) {
            candidates = candidates.filterWithMostCommonBitAtPosition(bitPosition--)
        }
        return candidates.first()
    }

    private fun diagnoseCO2(input: List<Int>, bitsSize: Int): Int {
        var candidates = input
        var bitPosition = bitsSize

        while (candidates.size != 1) {
            candidates = candidates.filterWithLeastCommonBitAtPosition(bitPosition--)
        }
        return candidates.first()
    }

    private fun List<Int>.filterWithMostCommonBitAtPosition(bitPosition: Int): List<Int> {
        val mostCommonBit = getMostCommonBitAtPosition(
            position = bitPosition,
            drawStrategy = DrawStrategy.Ceil
        )
        val bitMask = 1.shl(bitPosition - 1)
        return filter { it.and(bitMask).shr(bitPosition - 1) == mostCommonBit }
    }

    private fun List<Int>.filterWithLeastCommonBitAtPosition(bitPosition: Int): List<Int> {
        return this - this.filterWithMostCommonBitAtPosition(bitPosition)
    }

    /**
     * @returns 0 or 1 depending which bit is most common
     */
    private fun List<Int>.getMostCommonBitAtPosition(
        position: Int,
        drawStrategy: DrawStrategy = DrawStrategy.Floor
    ): Int {
        val mask = 1.shl(position - 1)
        return this
            .map { it.and(mask) }
            .map { if (it > 0) 1 else -1 }
            .sum()
            .let { sum ->
                when {
                    sum > 0 -> 1
                    sum < 0 -> 0
                    else -> when (drawStrategy) {
                        DrawStrategy.Ceil -> 1
                        DrawStrategy.Floor -> 0
                    }
                }
            }
    }

    private fun createMaskFor(bitsSize: Int): Int {
        var mask = 1
        repeat(bitsSize - 1) { mask = mask.shl(1) + 1 }
        return mask
    }

    private sealed class DrawStrategy {
        object Ceil : DrawStrategy()
        object Floor : DrawStrategy()
    }

}