package day7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CrabsAlignerTest {

    private val aligner = CrabsAligner()

    @Test
    fun `should calculate correct cost with no incremental engines`() {
        val actual = aligner.getCheapestAlignment(input, incrementalEngines = false)
        assertEquals(37, actual)
    }

    @Test
    fun `should calculate correct cost with incremental engines`() {
        val actual = aligner.getCheapestAlignment(input, incrementalEngines = true)
        assertEquals(168, actual)
    }

    companion object {
        val input = listOf(16,1,2,0,4,2,7,1,2,14)
    }
}