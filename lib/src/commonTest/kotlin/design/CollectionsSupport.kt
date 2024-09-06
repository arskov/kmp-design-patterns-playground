package design

import kotlin.test.Test

class CollectionsSupport {

    @Test
    fun `test if some collection factories are supported by KMP`() {
        val hashSet = hashSetOf("a", "b", "c")
        println(hashSet)
        val mutableSet = mutableSetOf("a", "b", "c")
        println(mutableSet)
    }
}