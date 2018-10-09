package observables

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {

    val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    list.toObservable()
            .filter { it.length >= 5 }
            .subscribeBy(
                    onNext = {
                        println(it)
                    },
                    onError = { it.printStackTrace() },
                    onComplete = { println("Done!") }
            )
}