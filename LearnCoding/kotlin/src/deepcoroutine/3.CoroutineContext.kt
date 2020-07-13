package deepcoroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    GlobalScope.launch(EmptyCoroutineContext + CoroutineName("haha") + CoroutineExceptionHandler({ context, throwabe ->
    })) {

    }
}