package design

import kotlin.test.Test

class EncKeyTest {

    @Test
    fun `tests jvmfield annotation in kmp`() {
        val key = EncKey("akey", byteArrayOf(0,0,0,0))
        println(key)
    }
}