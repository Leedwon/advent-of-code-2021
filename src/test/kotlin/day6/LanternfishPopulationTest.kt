package day6

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class LanternfishPopulationTest {

    private val population = LanternfishPopulation(initial)

    @Test
    fun `should calculate correct population for 18 days`() {
        val result = population.calculatePopulationSizeAfter(18)
        assertEquals(26, result)
    }


    @Test
    fun `should calculate correct population for 80 days`() {
        val result = population.calculatePopulationSizeAfter(80)
        assertEquals(5934, result)
    }

    @Test
    fun `should calculate correct population for 18 days optimized`() {
        val result = population.optimizedCalculatePosition(initialInts, 18)
        assertEquals(26, result)
    }


    @Test
    fun `should calculate correct population for 80 days optimized`() {
        val result = population.optimizedCalculatePosition(initialInts, 80)
        assertEquals(5934, result)
    }


    private companion object {
        val initialInts = listOf(3, 4, 3, 1, 2)
        val initial = initialInts.map(::Lanternfish)
    }
}