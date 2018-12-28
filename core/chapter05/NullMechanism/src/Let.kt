fun main(args: Array<String>) {
    val userId: String? = getUserId()
//    sendNotification(userId) // Error: Type mismatch. Required: String, Found: String?

    if (userId != null) sendNotification(userId) // Smart cast to kotlin.String
    userId?.let { userId -> sendNotification(userId) } // Name shadowed: userId
    userId?.let { sendNotification(userId) } // Smart cast to kotlin.String
    userId?.let { sendNotification(it) }
    userId?.let {
        println("Sent a notification message to $userId")
        println("Sent a notification message to $it")
    }
}

fun getUserId(): String? {
    return "user01"
//    return null
}

fun sendNotification(userId: String) {
    println("Sent a notification message to $userId")
}
