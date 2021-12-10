package day6

data class Lanternfish(
    private val initialValue: Int
) {
    private val RESET_VALUE = 6

     var daysToBirthLeft = initialValue
        set(value) {
            if (value == -1) {
                events.value = Event.Birth
                field = RESET_VALUE
            } else {
                field = value
            }
        }

    val events: Observable<Event> = Observable(Event.Init)

    fun onDayPassed() {
        daysToBirthLeft--
    }

    sealed class Event {
        object Init : Event()
        object Birth : Event()
    }
}