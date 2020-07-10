package deepcoroutine

import kotlinx.coroutines.delay
import kotlin.coroutines.*

fun main() {
//    val continuation = suspend {
//        println("in coroutine")
//        1
//    }.startCoroutine(object :Continuation<Int>{
//        override fun resumeWith(result: Result<Int>) {
//            println("result is ${result.getOrNull()}")
//        }
//
//        override val context: CoroutineContext = EmptyCoroutineContext
//    })
    callLaunchCoroutineRestricted()
}

fun callLaunchCoroutine(){
    launchCoroutine(ProducerScope<Int>()){
        println("In coroutine")
        produce(1000)
//        delay(1)
        produce(1001)
        1
    }
}

fun callLaunchCoroutineRestricted(){
    launchCoroutine(RestrictProducerScope<Int>()){
        println("In coroutine")
        produce(1000)
//        delay(1)
        produce(1001)
        1
    }
}

@RestrictsSuspension
class RestrictProducerScope<T> {
    suspend fun produce(value: T) {
        println("value is $value")
    }
}

class ProducerScope<T> {
    suspend fun produce(value: T) {
        println("value is $value")
    }
}

fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {
    block.startCoroutine(receiver, object : Continuation<T> {
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("result is ${result.getOrNull()}")
        }

    })
}

