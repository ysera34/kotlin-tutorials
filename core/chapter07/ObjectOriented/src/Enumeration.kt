fun main(args: Array<String>) {
    println(FriendType.SCHOOL)
    println("FriendType.SCHOOL.ordinal ${FriendType.SCHOOL.ordinal}")
    println("FriendType.COMPANY.ordinal ${FriendType.COMPANY.ordinal}")
    println(FriendType.SCHOOL.name)
    println(FriendType.valueOf("SCHOOL"))

    val friendTypes = FriendType.values()
    for (friendType in friendTypes) {
        println(friendType)
    }

    println(getFriendType(FriendType.SCHOOL))

    println(RGBColor.RED.rgbValue())
}

enum class FriendType {
    SCHOOL, COMPANY, SNS, OTHERS
}

fun getFriendType(friendType: FriendType) =
    when (friendType) {
        FriendType.SCHOOL -> "school friend"
        FriendType.COMPANY -> "company friend"
        FriendType.SNS -> "sns friend"
        FriendType.OTHERS -> "other friends"
    }

enum class RGBColor(val red: Int, val green: Int, val blue: Int) {
    RED(255, 0 , 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgbValue() = (red * 256 + green) * 256 + blue
}
