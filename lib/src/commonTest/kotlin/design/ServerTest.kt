package design

import kotlin.test.Test

object ServerTest {

    @Test
    fun initializationTest() {
        val server1: IServer = Server1(88)
        var serverDecorator1 = ServerDecorator(server1, listOf("a", "b", "c"))
        println("${server1.host}: ${server1.port}")
        println("${serverDecorator1.host}: ${serverDecorator1.port}")
        //println("${serverDecorator1.server}")
        serverDecorator1 += "fuck"
        serverDecorator1 += "fuck"
        serverDecorator1.forEach { println(it) }
        println(serverDecorator1.size)
        println(serverDecorator1.toOther().log())
    }
}