package observables

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {

    // print nothing to stdout
    Observable.just(5,6,7)
            .subscribeOn(Schedulers.io())
            .map { ";-}".repeat(it) }
            .subscribe(::println)
}