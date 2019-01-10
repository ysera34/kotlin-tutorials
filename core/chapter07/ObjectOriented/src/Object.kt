fun main(args: Array<String>) {
    for (i in 1..10) {
        StateManager.messageNumber += 1
        StateManager.messageContent = "${StateManager.messageNumber} message"
        StateManager.storeMessage()
    }
    OuterClass.InnerObject.printCount()
}

interface CaptureManager {
    fun capture()
}

// singleton object, lazy initialization
object StateManager : CaptureManager {
    var messageNumber: Int = 0
    var messageContent: String = ""

    fun storeMessage() {
        println("message = $messageNumber, content = $messageContent")
    }

    override fun capture() {}
}

class OuterClass {
    object InnerObject {
        var count: Int = 7
        fun printCount() {
            println(count)
        }
    }
}
