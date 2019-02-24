package observables

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val connectableObservable =
            Observable.interval(100, TimeUnit.MILLISECONDS)
                    .publish()
    connectableObservable.subscribe({ println("Subscription 1: $it") })
    connectableObservable.subscribe({ println("Subscription 2 $it") })
    connectableObservable.connect()
    runBlocking { delay(500) }

    // subscription 3 will received the emited data after delay of 500 msec
    // and can not receive the previous data
    connectableObservable.subscribe({ println("Subscription 3: $it") })
    runBlocking { delay(500) }
}