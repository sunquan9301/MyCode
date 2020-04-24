package coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
A builder function for Flow type is called flow.
Code inside the flow { ... } builder block can suspend.
The function foo() is no longer marked with suspend modifier.
Values are emitted from the flow using emit function.
Values are collected from the flow using collect function.
 */


fun main() = runBlocking<Unit> {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow
    foo().collect { value -> println(value) }
}
//sampleEnd

//sampleStart
fun foo(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
//        delay(300)
        println("i = $i")
        Thread.sleep(300)//re doing something useful here
        emit(i) // emit next value
    }
}