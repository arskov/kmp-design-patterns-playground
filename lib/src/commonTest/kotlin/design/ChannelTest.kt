package design

import kotlin.test.Test
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedSendChannelException
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith

class ChannelTest {

    @Test
    fun testChannelSendReceive() = runTest {
        // Create a Channel
        val channel = Channel<Int>()

        // Launch a coroutine to send data to the channel
        launch {
            for (i in 1..5) {
                channel.send(i)
            }
            channel.close() // Close the channel after sending all elements
        }

        // Receive and test data from the channel
        val receivedValues = mutableListOf<Int>()
        for (value in channel) {
            receivedValues.add(value)
        }

        // Assertions
        assertEquals(listOf(1, 2, 3, 4, 5), receivedValues)
    }

    @Test
    fun testChannelClosedException() = runTest {
        // Create a Channel
        val channel = Channel<Int>()
        channel.close() // Close the channel immediately

        // Assert that sending to a closed channel throws an exception
        val exception = assertFailsWith<ClosedSendChannelException> {
            channel.send(1)
        }

        assertTrue(exception is ClosedSendChannelException)
    }

}