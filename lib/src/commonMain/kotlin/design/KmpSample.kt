package design

import kotlinx.cinterop.*
import platform.posix.memcpy

object KmpObject {
    val name: String = "KotlinObject"
    override fun toString(): String = "KmpObject($name)"
}

interface KmpInterface {
    fun interfaceMethod(): String
}

class KmpClazz: KmpInterface {
    fun returnLong(): Long? = 42L
    fun returnInt(): Int? = 42
    override fun interfaceMethod(): String {
        return "KmpClazz"
    }

    protected fun finalize() {
        println("The instance of $this is being finalized")
    }
}

fun acceptInteger(i: Int?) {
    println("Got Int($i) from Native")
}
fun acceptDouble(d: Double?) {
    println("Got Double($d) from Native")
}

fun acceptString(str: String?) :  String {
    println("Got '$str' from Native")
    return "That is '$str' from Native"
}

fun acceptInvokeFun(f: (String) -> String) {
    val nativeFunctionResult = f("String param from Kotlin")
    println("String result '$nativeFunctionResult' from Native function")
}

fun supplyFun() : (String) -> String? =
    { "A String function param from Native '$it' is returned as a part of Kotlin string" }

fun readNativeByteArray(byteArray: CPointer<ByteVar>, size: Int) {
    println("ReadBytes: ${byteArray.readBytes(size).toHexString()}")
    val tmp = ByteArray(size)
    memcpy(tmp.pin().addressOf(0), byteArray, size.toULong())
    println("Memcpy: ${tmp.toHexString()}")
}

fun readByteArray(byteArray: ByteArray) {
    println(byteArray.contentToString())
}