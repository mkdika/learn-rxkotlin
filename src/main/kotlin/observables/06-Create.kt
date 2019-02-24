package observables

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main() {

    val observable = Observable.create<Int> {
        it.onNext(5)
        it.onNext(6)
        it.onNext(7)
        it.onComplete() // State onComplete explicitly or observer's onComplete method will never be called.
    }
    observable.subscribeBy(
            onNext = {
                println("Received: $it")
            },
            onComplete = {
                println("Done, received all!")
            }
    )
}