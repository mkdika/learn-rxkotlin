package flowables

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Flowable are same as Observable, except Flowable have a backpressure feature.
 * Default buffer for backpressure is 128.
 */
fun main() {
    Flowable.range(1, 1000)
        .map {
            MyItem(it)
        }
        .observeOn(Schedulers.io())
        .subscribe({
            println("Received $it")
            runBlocking { delay(100) }
        }, { it.printStackTrace() })
    runBlocking { delay(60000) }
}

data class MyItem(val id: Int) {
    init {
        println("MyItem Created $id")
    }
}