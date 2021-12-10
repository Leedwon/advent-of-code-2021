package day6

class LanternfishPopulation(private val initial: List<Lanternfish>) {

    private val newbornValue = 8

    fun calculatePopulationSizeAfter(days: Int): Int {
        val populationCopy = initial.map { it.copy() }.toMutableList()
        val eventsToHandle: MutableList<Lanternfish.Event.Birth> = mutableListOf()

        fun onFishBorn() {
            eventsToHandle.add(Lanternfish.Event.Birth)
        }

        populationCopy.forEach { lanternfish ->
            lanternfish.listenToBirths(::onFishBorn)
        }

        repeat(days) {
            populationCopy.forEach { lanternfish -> lanternfish.onDayPassed() }
            val birthsCount = eventsToHandle.size
            eventsToHandle.clear()
            repeat(birthsCount) {
                val newFish = Lanternfish(newbornValue)
                populationCopy.add(newFish)
                newFish.listenToBirths(::onFishBorn)
            }
        }

        return populationCopy.size
    }

    private fun Lanternfish.listenToBirths(onNewBirth: () -> Unit) {
        this.events.subscribe {
            when (it) {
                Lanternfish.Event.Birth -> onNewBirth()
                Lanternfish.Event.Init -> {
                    //no-op
                }
            }
        }
    }

    fun optimizedCalculatePosition(input: List<Int>, days: Int): Long {
        val population = mutableMapOf<Int, Long>()

        repeat(9) {
            population[it] = 0
        }

        for (element in input) {
            population[element] = (population[element] ?: 0) + 1
        }

        repeat(days) {
            val old = population.toMap()
            population.clear()
            old.keys.sortedDescending().forEach { dayToBirth ->
                val count = old[dayToBirth] ?: 0
                val decreased = dayToBirth - 1
                if (decreased != -1) {
                    population[decreased] = count
                } else {
                    population[8] = count
                    population[6] = (population[6] ?: 0) + count
                }
            }
        }

        return population.values.sum()
    }

}