package observables

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main() {
    val observable: Observable<String> = listOf("String 1", "String 2", "String 3", "String 4").toObservable()//1

    observable.subscribe(
            {
                println("Received $it") // onNext
            },
            {
                println("Error ${it.message}") // onError
            },
            {
                println("Done") // onComplete
            }
    )

    observable.subscribe(
            {
                println("Received $it")
            },
            {
                println("Error ${it.message}")
            },
            {
                println("Done")
            }
    )
}