package coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

//fun CoroutineScope.consumer(channel:Channel<Int>) =
fun main() = runBlocking<Unit> {
//sampleStart
    val channel = Channel<Int>(4) // create buffered channel
    val sender = launch { // launch sender coroutine
        repeat(10) {
            println("Sending $it") // print before sending each element
            channel.send(it) // will suspend when buffer is full
        }
    }
    val consumer = launch {
        repeat(5) {
            println("consumer $it")
            delay(100)
            channel.receive()
        }
    }
    // don't receive anything... just wait....
    delay(1000)
    sender.cancel() // cancel sender coroutine
//sampleEnd
}