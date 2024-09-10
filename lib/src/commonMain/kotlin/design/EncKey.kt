package design

import kotlin.jvm.JvmField

class EncKey(
    @JvmField val name: String,
    @JvmField val key: ByteArray,
) {
    @OptIn(ExperimentalStdlibApi::class)
    override fun toString(): String {
        return "EncKey($name, ${key.toHexString()})"
    }
}