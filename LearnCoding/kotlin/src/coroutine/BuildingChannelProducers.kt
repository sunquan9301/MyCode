package coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

class BuildingChannelProducers {

}


fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..100) send(x * x)
}

fun main() = runBlocking {
//sampleStart
    val squares = produceSquares()
    squares.consumeEach { println(it) }
    println("Done!")
//sampleEnd
}

