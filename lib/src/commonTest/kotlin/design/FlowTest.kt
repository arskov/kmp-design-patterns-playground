package design

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.test.Test

class FlowTest {

    @Test
    fun flowTest() = runTest {
        val numberFlow = flow {
            (0..9).forEach {
                println("Sending $it")
                emit(it)
            }
        }

        (0..4).forEach { coroutineId ->
            delay(5000)
            launch(Dispatchers.Default) {
                numberFlow.collect { number ->
                    delay(1000)
                    println("Coroutine $coroutineId received $number")
                }
            }
        }
    }
}