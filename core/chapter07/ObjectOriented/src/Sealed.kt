fun main(args: Array<String>) {
    val sealedType1FriendType = SealedType1FriendType.School("john", 1)
    println("${sealedType1FriendType.name} ${sealedType1FriendType.schoolType}")

    val sealedType2FriendType = School("peter", 2)
    println("${sealedType2FriendType.name} ${sealedType2FriendType.schoolType}")
}

// Used as a nested class inside a sealed class
sealed class SealedType1FriendType {
    class School(val name: String, val schoolType: Int) : SealedType1FriendType()
    class Company: SealedType1FriendType()
    class Sns: SealedType1FriendType()
    class Others: SealedType1FriendType()
}

// Defined as an independent class
sealed class SealedType2FriendType
class School(val name: String, val schoolType: Int) : SealedType2FriendType()
class Company: SealedType2FriendType()
class Sns: SealedType2FriendType()
class Others: SealedType2FriendType()
