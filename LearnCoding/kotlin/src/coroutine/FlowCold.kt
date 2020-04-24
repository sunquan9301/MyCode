// This file was automatically generated from flow.md by Knit tool. Do not edit.

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        println("foo"+i)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("Calling foo...")
    val flow = foo()
    println("Calling collect...")
    flow.collect { value -> println("next"+value) }
    println("Calling collect again...")
    flow.collect { value -> println("next2"+value) }
}