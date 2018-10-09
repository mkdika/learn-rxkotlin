package observables

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {

    val observable = Observable.create<Int> {
        it.onNext(5)
        it.onNext(6)
        it.onNext(7)
        it.onComplete()
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