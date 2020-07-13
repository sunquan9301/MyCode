package deepcoroutine.ch04.python

import kotlin.coroutines.*


fun main() {
    val continuation = suspend {
        for (i in 0..5) {
            yield(i)
        }
    }.createCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            println("resumeWith")
        }
    })
    println(continuation.hashCode())
    continuation.resume(Unit)
}

suspend fun yield(value: Int) = suspendCoroutine<Int> { continuation ->
    println("hahaha $value; code = ${continuation.hashCode()}")
//    continuation.resume(1)
}

