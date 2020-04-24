import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo1(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) { // Timeout after 250ms
        foo1().collect { value -> println(value) }
    }
    println("Done")
}