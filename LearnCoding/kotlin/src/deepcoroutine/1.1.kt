package deepcoroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {
    GlobalScope.launch {
        val bitmap = bitmapSuspendable("...")
    }
    runBlocking {

    }
}

class Bitmap {

}

fun download(url: String): Bitmap {
    return Bitmap();
}

suspend fun bitmapSuspendable(url: String): Bitmap = suspendCoroutine { continuation ->
    thread {
        try {
            continuation.resume(download(url))
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }
}