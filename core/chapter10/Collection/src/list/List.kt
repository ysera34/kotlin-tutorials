package list

import java.util.*

data class FriendOfMine(val name: String, val age: Int, val tel: String)

fun readList(friends: List<FriendOfMine>) {
    println("***** friends.size: ${friends.size}, friends.indices: ${friends.indices}")
    for (friendIndex in friends.indices) {
        println("$friendIndex -> $friends[friendIndex]")
    }

    println("\n***** friends.isEmpty(): ${friends.isEmpty()}")
    println("***** friends.isNotEmpty(): ${friends.isNotEmpty()}")
    println("***** friends.none(): ${friends.none()}")
    println("***** friends.contains(): ${friends.contains(FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"))}")

    val index = friends.indexOf(FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"))
    println("\n***** friends.get(index): ${friends.get(index)}")
    println("***** friends[index]: ${friends[index]}")
    println("***** friends.getOrNull(index): ${friends.getOrNull(10)}")
    println("***** friends.getOrNull(index): ${friends.elementAt(index)}")
    println("***** friends.getOrNull(index): ${friends.elementAtOrNull(10)}")

    println("\n***** friends.first(): ${friends.first()}")
    println("***** friends.last(): ${friends.last()}")

    println("\n***** friends.count(): ${friends.count()}")
    println("***** friends.distinct().count(): ${friends.distinct().count()}")

    println("\n***** friends.component1()..friends.component1()")
    val friend1: FriendOfMine = friends.component1()
    val friend2: FriendOfMine = friends.component2()
    val friend3: FriendOfMine = friends.component3()
    val friend4: FriendOfMine = friends.component4()
    val friend5: FriendOfMine = friends.component5()
    println("${friend1.name} ${friend2.name} ${friend3.name} ${friend4.name} ${friend5.name}")

    println("\n***** collection destructuring")
    val (friend11, friend22, friend33, friend44, friend55) = friends
    println("${friend11.name} ${friend22.name} ${friend33.name} ${friend44.name} ${friend55.name}")

    println("\n***** friends.joinToString")
    for (friend in friends) {
        println("${friends.joinToString(", ")}")
    }
}

fun readListLambda(friends: List<FriendOfMine>) {
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
    val filteredList = friends.filter { it.age >= 35 }
    filteredList.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.map()")
    val mapList = filteredList.map(FriendOfMine::name)
    println(mapList)

    println("\n***** friends.filter() with map()")
    val filteredMapList1 = friends.filter { it.age >= 35 }.map(FriendOfMine::name)
    val filteredMapList2 = friends.filter { it.age >= 35 }.map { it.name }
    println(filteredMapList1)
    println(filteredMapList2)
}

fun modifyList(friends: MutableList<FriendOfMine>) {
    println("\n***** friends.add()")
    friends.add(FriendOfMine("Jeremy Renner", 30, "000-0000-0000"))
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.addAll()")
    val friendList = listOf(FriendOfMine("Tom Hiddleston", 30, "000-0000-0000"))
    friends.addAll(friendList)
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.removeAt()")
    friends.removeAt(6)
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.removeAt()")
    friends.set(4, FriendOfMine("Clark Gregg", 30, "000-0000-0000"))
    friends[4] = FriendOfMine("Clark Gregg", 30, "000-0000-0000")
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friendsSub1.subList()")
    val friendsSub1 = friends.subList(0, 2)
    friendsSub1.forEach { println("${it.name} ${it.age} ${it.tel}") }
    println(friends.containsAll(friendsSub1))

    println("\n***** friendsSub2.slice()")
    val friendsSub2 = friends.slice(0..2)
    friendsSub2.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friendsRev.asReversed()")
    val friendsRev = friends.asReversed()
    friendsRev.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friendsRev.clear()")
    friendsRev.clear()
    println(friendsRev)

    val ls = friends.toList()
    val ml = friends.toMutableList()
    val st = friends.toSet()
    val ms = friends.toMutableSet()
    val hs = friends.toHashSet()
}

fun useOnlyLinkedList(friends: LinkedList<FriendOfMine>) {
    println("\n***** addFirst(), addLast()")
    friends.addFirst(FriendOfMine("Cobie Smulders", 30, "000-0000-0000"))
    friends.addLast(FriendOfMine("Stellan Skarsgård", 30, "000-0000-0000"))
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friends.first(): ${friends.first()}")
    println("***** friends.last(): ${friends.last()}")

    println("\n***** removeFirst(), removeLast()")
    friends.removeFirst()
    friends.removeLast()
    friends.forEach { println("${it.name} ${it.age} ${it.tel}") }
}

fun others(nList: List<Int>) {
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
    var friends1 = arrayListOf(
        FriendOfMine("Robert Downey Jr.", 30, "000-0000-0000"),
        FriendOfMine("Chris Evans", 31, "000-0000-0000"),
        FriendOfMine("Mark Ruffalo", 32, "000-0000-0000"),
        FriendOfMine("Chris Hemsworth", 33, "000-0000-0000"),
        FriendOfMine("Scarlett Johansson", 34, "000-0000-0000")
    )

    var friends2 = LinkedList(friends1)

    readList(friends1)

    readListLambda(friends1)

    modifyList(friends1)

    useOnlyLinkedList(friends2)

    val nL = arrayListOf(20, 10, 50, 40, 30)
    others(nL)
}
