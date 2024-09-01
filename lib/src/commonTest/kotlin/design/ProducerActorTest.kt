package design

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ProducerActorTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun producerActorTest() = runTest {
        val numberChannel = produce<Int> {
            (0..9).forEach {
                println("Producing a number $it")
                send(it)
            }
        }
        (0..3).forEach { coroutineId ->
            launch(Dispatchers.Default) {
                for (n in numberChannel) {
                    println("Coroutine $coroutineId got number $n")
                }
            }
        }
    }
}