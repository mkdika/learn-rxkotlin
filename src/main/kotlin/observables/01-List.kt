package observables

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    list.toObservable()
        .filter { it.length >= 5 }
        .subscribeBy(
            onNext = {
                runBlocking {
                    delay(1000)
                }
                println(it)
            },
            onError = { it.printStackTrace() },
            onComplete = { println("Done!") }
        )


    list.toObservable().subscribeBy()
}