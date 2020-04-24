package coroutine

import kotlinx.coroutines.channels.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking<Unit> {
    val tickerChannel = ticker(delayMillis = 100, initialDelayMillis = 0) // create ticker channel
//
//    for (x in tickerChannel) {
//        println(x)
//    }
    var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
//    println("Initial element is available immediately: $nextElement") // initial delay hasn't passed yet
    println("11  " + System.currentTimeMillis())
    nextElement = withTimeoutOrNull(200) { tickerChannel.receive() } // all subsequent elements has 100ms delay
//    println("Next element is not ready in 50 ms: $nextElement")
    println("22  " + System.currentTimeMillis())



    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100 ms: $nextElement")
    println("33" + System.currentTimeMillis())
    // Emulate large consumption delays
    println("Consumer pauses for 150ms")
    delay(150)
    // Next element is available immediately
    nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Next element is available immediately after large consumer delay: $nextElement")
    // Note that the pause between `receive` calls is taken into account and next element arrives faster
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")
    tickerChannel.cancel() // indicate that no more elements are needed
}