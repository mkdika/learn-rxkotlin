package observables

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy


fun main() {

    Observable.just("A String")
            .subscribeBy(
                    onNext = {
                        println("Length is ${it.length}")
                    },
                    onComplete = {
                        println("Its complete!")
                    }
            )

}