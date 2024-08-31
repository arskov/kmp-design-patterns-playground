package design

interface IServer {
    val host: String
    val port: Int
}

class Server1(override val port: Int) : IServer {
    override val host = "Server1"
}

class ServerDecorator(private val server: IServer, private val someList: List<String>) : IServer by server,
    List<String> by someList {
    override val host = "ServerDecorator"

    override val size: Int
        get() {
            require(someList.size > 4) {
                "Weird error"
            }
            return someList.size
        }

    operator fun plus(element: String): ServerDecorator {
        val newList = someList + element
        return ServerDecorator(server, newList)
    }
}

interface IOther {
    fun log(): String
}

fun ServerDecorator.toOther(): IOther {
    val someFn = if (this.size > 0) "TRUE" else "FALSE"

    return object : IOther {
        override fun log(): String {
            return someFn
        }
    }
}
