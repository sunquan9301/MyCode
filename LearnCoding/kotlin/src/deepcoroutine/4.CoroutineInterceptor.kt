package deepcoroutine

import kotlin.concurrent.thread
import kotlin.coroutines.*

/**
 *  suspend 需要个continutant实例，因此suspendFunc02里，在startCoroutine 会传入一个 （object:Continuation<Int>)
 *  会传入到suspend； 因此 suspend resume的时候会回到挂起点；
 *  最后一个resumeWith会执行 object:Continuation里的resumeWith
 */
fun main() {
    suspend {
        suspendFunc02("hello", "kotlin")
        Thread.sleep(3000)
        println("next")
        suspendFunc02("hello", "Coroutine")
        println("next1")
        suspendFunc02("hello", "Coroutine1")
    }.startCoroutine(object : Continuation<Int> {
        override val context = LoginInterceptor()

        override fun resumeWith(result: Result<Int>) {
            //只执行最后一次的resume
            println("coroutine resumeWith 1")
        }
    })
}

suspend fun suspendFunc01(a: String, b: String) = suspendCoroutine<Int> { continuant ->
    thread {
        Thread.sleep(500)
        println(Thread.currentThread().id)
        continuant.resumeWith(Result.success(5))
    }
}



suspend fun suspendFunc02(a: String, b: String) = suspendCoroutine<Int> { continuant ->
    thread {
        Thread.sleep(500)
        println("before suspendFunc02" + Thread.currentThread().id)
        continuant.resumeWith(Result.success(5))
        println("after suspendFunc02" + Thread.currentThread().id)

    }
}

class LogContinuation<T>(private val continuation: Continuation<T>) : Continuation<T> by continuation {
    override fun resumeWith(result: Result<T>) {
        println("before Interceptor resumeWith : $result; id = ${Thread.currentThread().id}")
        continuation.resumeWith(result)
        println("after Interceptor resumeWith : $result")
    }
}

class LoginInterceptor : ContinuationInterceptor {
    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return LogContinuation(continuation)
    }
}