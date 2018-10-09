package observables

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy


fun main(args: Array<String>) {

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