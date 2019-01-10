fun main(args: Array<String>) {
    for (i in 1..10) {
        StateManager.messageNumber += 1
        StateManager.messageContent = "${StateManager.messageNumber} message"
        StateManager.storeMessage()
    }
    OuterClass.InnerObject.printCount()
    OuterClass.CompanionObject.printMessage() // Redundant Companion reference
    OuterClass.printMessage()

//    val privateClass = PrivateClass() // Error: Cannot access '<init>': it is private in 'PrivateClass'
    PrivateClass.create().printPrivateClass()
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

    companion object CompanionObject {
        fun printMessage() {
            println("called companion object")
        }
    }

//    companion object {} // Error: Only one companion object is allowed per class
}

class PrivateClass {
    private constructor()
    companion object {
        fun create(): PrivateClass = PrivateClass()
    }

    fun printPrivateClass() {
        println("called function of factory object")
    }
}
