package map

data class FriendOfMine(val name: String, val age: Int, val tel: String)

fun readMap(friends: Map<Int, FriendOfMine>) {
    println("***** for, forEach, onEach")
    for ((key, value) in friends) {
        println("Key = $key, Value = $value")
    }

    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.size: ${friends.size}")

    println("\n***** friends.isEmpty(): ${friends.isEmpty()}")
    println("***** friends.isNotEmpty(): ${friends.isNotEmpty()}")
    println("***** friends.none(): ${friends.none()}")

    println("\n***** friends.contains(2): ${friends.contains(2)}")
    println("***** friends.containsKey(2): ${friends.containsKey(2)}")
    val friend = FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000")
    println("***** friends.containsValue(FriendOfMine(...)): ${friends.containsValue(friend)}")

    println("\n***** friends.count(): ${friends.count()}")
    println("***** friends.count { it.value.age >= 32 }: ${friends.count { it.value.age >= 32 }}")

    println("\n***** friends.get(2): ${friends.get(2)}")
    println("***** friends[2]: ${friends[2]}")
}

fun modifyMap(friends: MutableMap<Int, FriendOfMine>) {
    val friend = FriendOfMine("Jeremy Renner", 30, "000-0000-0000")
    println("\n***** friends.set(index, FriendOfMine(...)):")
    friends.set(6, friend)
    friends[6] = friend
    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.put(index, FriendOfMine(...)):")
    friends.put(2, FriendOfMine("Tom Hiddleston", 30, "000-0000-0000"))
    friends.put(7, FriendOfMine("Clark Gregg", 30, "000-0000-0000"))
    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.plusAssign(Pair(index, FriendOfMine(...))): Unit")
    friends.plusAssign(Pair(8, FriendOfMine("Cobie Smulders", 30, "000-0000-0000")))
    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.plus(Pair(index, FriendOfMine(...))): Map<>")
    val newFriends = friends.plus(Pair(9, FriendOfMine("Stellan Skarsgård", 30, "000-0000-0000")))
    newFriends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.getOrPut(index, { FriendOfMine(...) })")
    val newFriend = friends.getOrPut(9) { FriendOfMine("Samuel L. Jackson", 30, "000-0000-0000") }
    println("newFriend: $newFriend")
    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.removeAt(7): ${friends.remove(7)}")
    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }
}

fun mapWithLambda(friends: MutableMap<Int, FriendOfMine>) {
    println("\n***** origin friends")
    friends.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.mapKeys {  }")
    val friendMap1 = friends.mapKeys { it.value.age }
    friendMap1.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.mapValues {  }")
    val friendMap2 = friends.mapValues { it.value.age }
    friendMap2.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.filterKeys {  }")
    val friendMap3 = friends.filterKeys { it > 5 }
    friendMap3.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.filter {  }")
    val friendMap4 = friends.filter { it.key > 5 }
    friendMap4.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.filterValues {  }")
    val friendMap5 = friends.filterValues { it.age > 32 }
    friendMap5.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.filter {  }")
    val friendMap6 = friends.filter { it.value.age > 32 }
    friendMap6.forEach { key, value ->
        println("Key = $key, Value = $value")
    }

    println("\n***** friends.clear()")
    val friendMap7 = friendMap1 as MutableMap
    friendMap7.clear()
    println(friendMap7)
    println(friendMap1)
    println()

    val ls = friends.toList()
    val ml = friends.toMutableMap()
    val mp = friends.toMap()
    val sm = friends.toSortedMap()

    println("ls: ${ls.javaClass.canonicalName}")
    println("ml: ${ml.javaClass.canonicalName}")
    println("mp: ${mp.javaClass.canonicalName}")
    println("sm: ${sm.javaClass.canonicalName}")
}

fun main(args: Array<String>) {
    val friends = mutableMapOf(
        1 to FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"),
        2.to(FriendOfMine("Chris Evans", 31, "000-0000-0000")),
        Pair(3, FriendOfMine("Mark Ruffalo", 32, "000-0000-0000")),
        4 to FriendOfMine("Chris Hemsworth", 33, "000-0000-0000"),
        5 to FriendOfMine("Scarlett Johansson", 34, "000-0000-0000")
    )

    readMap(friends)

    modifyMap(friends)

    mapWithLambda(friends)
}
