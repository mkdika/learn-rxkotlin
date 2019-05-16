package observables

import io.reactivex.Single

fun main() {
  fibonacciAsync(1000)
      .subscribe({
          println("result: $it")
      },{
         println("Error: $it")
      })
}

// fib with probability to be high computational
// process
private fun fib(n: Long): Long {
    return if (n <= 1) n
    else fib(n - 1) + fib(n -2)
}

// wrap fib process with Async single
fun fibonacciAsync(number: Long): Single<Long> =
    Single.create(){
        val result = fib(number)
        if (it != null && !it.isDisposed) {
            it.onSuccess(result)
        }
    }