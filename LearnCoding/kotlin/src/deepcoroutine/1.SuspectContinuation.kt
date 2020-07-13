package deepcoroutine

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.*

fun main() {
//    GlobalScope.launch {
//        println("GlobalScope.launch")
//        val bitmap = bitmapSuspendable("...")
////        delay(3000)
//        println(bitmap)
//    }
////    Thread.sleep(5000) //阻塞5s来保证JVM存活
//    println("hahaha")
    val ref = ::bitmapSuspendable
    ref.call("...",object :Continuation<String>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<String>) {
            println("kotlin normal func invoke suspect ")
        }

    })
}


class Bitmap {

}

fun download(url: String): String = url

suspend fun bitmapSuspendable(url: String): String {
    return suspendCoroutine<String> { continuation ->
        thread {
            try {
                println("continuation.resume")
                continuation.resume(download(url))
                println("after continuation.resume")

            } catch (e: Exception) {
                println("resumeWithException")
                continuation.resumeWithException(e)
            }
        }
    }
}