package coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

class Pipelines {
}

fun CoroutineScope.numbers(): ReceiveChannel<Int> = produce {
    var x = 1;
    while (true) send(x++)
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce<Int> {
    for (x in numbers) send(x * x)
}

fun main() = runBlocking {
    val numbers = numbers();
    val square = square(numbers);
    repeat(5) {
        println(square.receive())
    }
    coroutineContext.cancelChildren() // cancel children coroutines
}