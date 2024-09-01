package design

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class DeferredTest {

    @Test
    fun deferredTest1() = runTest {
        val d = async {
            delay(1000)
            println("Async complete")
        }
        d.await()
        println("After await")
    }

    @Test
    fun deferredTest2() = runTest {
        val out = valueAsync().await()
        println(out)
    }

    suspend fun valueAsync(): Deferred<String> = coroutineScope {
        val deferred = CompletableDeferred<String>()
        launch {
            delay(1000)
            deferred.complete("Done")
        }
        deferred
    }

}