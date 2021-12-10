package day6

interface Disposable {
    fun dispose()
}

private typealias Observer<T> = (T) -> Unit

class Observable<T>(initialValue: T) {
    private val observers = mutableListOf<Observer<T>>()

    var value: T = initialValue
        set(value) {
            field = value
            observers.forEach { it.invoke(value) }
        }

    fun subscribe(onNext: (T) -> Unit): Disposable {
        observers.add(onNext)
        return object : Disposable {
            override fun dispose() {
                observers.remove(onNext)
            }
        }
    }
}

