package day8

sealed class SevenSegmentsDisplayElement {
    abstract val wiresUsed: Int

    object Zero : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 6
    }

    object One : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 2
    }

    object Two : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 5
    }

    object Three : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 5
    }

    object Four : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 4
    }

    object Five : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 5
    }

    object Six : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 6
    }

    object Seven : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 3
    }

    object Eight : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 7
    }

    object Nine : SevenSegmentsDisplayElement() {
        override val wiresUsed: Int
            get() = 6
    }

    companion object {
        val uniqueElements = listOf(
            One,
            Four,
            Seven,
            Eight
        )
    }
}
