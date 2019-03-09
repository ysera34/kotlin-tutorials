package set

data class FriendOfMine(val name: String, val age: Int, val tel: String)

fun readSet(friends: Set<FriendOfMine>) {
    println("***** friends.size: ${friends.size}, friends.indices: ${friends.indices}")
    for (friendIndex in friends.indices) {
        println("$friendIndex -> $friends[friendIndex]")
    }

    println("\n***** friends.isEmpty(): ${friends.isEmpty()}")
    println("***** friends.isNotEmpty(): ${friends.isNotEmpty()}")
    println("***** friends.none(): ${friends.none()}")
    println("***** friends.contains(): ${friends.contains(FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"))}")

    val index = friends.indexOf(FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"))
    println("***** friends.getOrNull(index): ${friends.elementAt(index)}")
    println("***** friends.getOrNull(index): ${friends.elementAtOrNull(10)}")

    println("\n***** friends.first(): ${friends.first()}")
    println("***** friends.last(): ${friends.last()}")

    println("\n***** friends.count(): ${friends.count()}")
    println("***** friends.distinct().count(): ${friends.distinct().count()}")

    println("\n***** friends.joinToString")
    for (friend in friends) {
        println("${friends.joinToString(", ")}")
    }
}

fun readSetLambda(friends: Set<FriendOfMine>) {
    println("\n***** friends.count() with lambda")
    val countFriend = friends.count { it.age >= 33 }
    println("Number of friends over 33: $countFriend")

    println("\n***** for, forEach, onEach")
    for (friend in friends) {
        println("${friend.name} ${friend.age} ${friend.tel}")
    }
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }
    friends.onEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.sortedWith() with lambda")
    val sortedList1 = friends.sortedWith(compareBy({ it.name }, { it.age }))
    sortedList1.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.sortedWith() with class member property reference")
    val sortedList2 = friends.sortedWith(compareBy(FriendOfMine::name, FriendOfMine::age))
    sortedList2.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.filter() with lambda")
    val filteredList = friends.filter { it.age >= 33 }
    filteredList.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.map()")
    val mapList = filteredList.map(FriendOfMine::name)
    println(mapList)

    println("\n***** friends.filter() with map()")
    val filteredMapList1 = friends.filter { it.age >= 33 }.map(FriendOfMine::name)
    val filteredMapList2 = friends.filter { it.age >= 33 }.map { it.name }
    println(filteredMapList1)
    println(filteredMapList2)
}

fun modifySet(friends: MutableSet<FriendOfMine>) {
    println("\n***** friends.add()")
    friends.add(FriendOfMine("Jeremy Renner", 30, "000-0000-0000"))
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.addAll()")
    val friendList = listOf(FriendOfMine("Tom Hiddleston", 30, "000-0000-0000"))
    friends.addAll(friendList)
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    val ls = friends.toList()
    val ml = friends.toMutableList()
    val st = friends.toSet()
    val ms = friends.toMutableSet()
    val hs = friends.toHashSet()

    println("ls: ${ls.javaClass.canonicalName}")
    println("ml: ${ml.javaClass.canonicalName}")
    println("st: ${st.javaClass.canonicalName}")
    println("ms: ${ms.javaClass.canonicalName}")
    println("hs: ${hs.javaClass.canonicalName}")
}

fun useOnlyLinkedHashSet(friends: LinkedHashSet<FriendOfMine>) {
    println("\n***** friends.first(): ${friends.first()}")
    println("***** friends.last(): ${friends.last()}")
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }
}

fun othersSet(nList: Set<Int>) {
    println("\n***** max(), min(), count() with lambda, sum()")
    println(nList.max())
    println(nList.min())
    println(nList.count())
    println(nList.count { it > 2 })
    println(nList.sum())

    println("\n***** sorted()")
    val sList = nList.sorted()
    println("before sorting: $nList, after sorting: $sList")

    println("\n***** flatMap() with lambda")
    val flatMapList = nList.flatMap { listOf(it, it + 1) }
    println(flatMapList)
}

fun main(args: Array<String>) {
    var friends1 = hashSetOf(
        FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"),
        FriendOfMine("Chris Evans", 31, "000-0000-0000"),
        FriendOfMine("Mark Ruffalo", 32, "000-0000-0000"),
        FriendOfMine("Chris Hemsworth", 33, "000-0000-0000"),
        FriendOfMine("Scarlett Johansson", 34, "000-0000-0000")
    )

    var friends2 = LinkedHashSet(friends1)

    readSet(friends1)

    readSetLambda(friends1)

    modifySet(friends1)

    useOnlyLinkedHashSet(friends2)

    val nL = setOf(20, 10, 50, 40, 30)
    othersSet(nL)
}
