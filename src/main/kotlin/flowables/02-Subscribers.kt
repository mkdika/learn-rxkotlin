package flowables

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main(args: Array<String>) {
    Flowable.range(1, 15)
            .map { MyItem6(it) }
            .observeOn(Schedulers.io())
            .subscribe(object : Subscriber<MyItem6> {
                lateinit var subscription: Subscription
                override fun onSubscribe(subscription: Subscription) {
                    this.subscription = subscription
                    subscription.request(5)
                }

                override fun onNext(s: MyItem6?) {
                    runBlocking { delay(100) }
                    println("Subscriber received " + s!!)
                    if (s.id == 5) {//(3)
                        println("Requesting two more..")
                        subscription.request(2)//(4)
                    }
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

                override fun onComplete() {
                    println("Done!")
                }
            })
    runBlocking { delay(10000) }
}

data class MyItem6(val id: Int) {
    init {
        println("MyItem Created $id")
    }
}