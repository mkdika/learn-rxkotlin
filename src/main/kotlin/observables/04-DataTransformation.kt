package observables

import io.reactivex.Observable


fun main() {
    Observable.just(5,6,7,8,9,10)
            .filter{ it % 2 ==0}
            .map { ";-)".repeat(it) }
            .subscribe(::println)
}