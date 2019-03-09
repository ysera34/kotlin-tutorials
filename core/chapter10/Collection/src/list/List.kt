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
    println(friends.containsAll(friendsSub2))

    println("\n***** friendsRev.asReversed()")
    val friendsRev = friends.asReversed()
    friendsRev.forEach { println("${it.name} ${it.age} ${it.tel}") }

    println("\n***** friendsRev.clear()")
    friendsRev.clear()
    println(friendsRev)
    println(friends)

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

fun `create a new array by adding indexes`() {
    val list = listOf(2, 5, 1, 7, 8)

    val lt1 = list.withIndex().filter { (i, _) -> i % 2 == 0 }
    val lt2 = list.withIndex().filter { it.index % 2 == 0 }

    println(lt1)
    println(lt2)

    val ls = listOf("Robert Downey Jr.", "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Scarlett Johansson")
    println("\n***** withIndex()")
    val lt11 = ls.withIndex().filter { it.index > 2 && it.value.startsWith("Chris") }

    lt11.forEach { (i, v) -> print("$v at $i, ") }
    println()
    lt11.forEach { print("${it.value} at ${it.index}, ") }

    println("\n***** filterIndexed()")
    val lt22 = ls.filterIndexed { index, _ -> index % 2 == 0 }
    println(lt22)

    println("\n***** mapIndexed()")
    val lt33 = ls.mapIndexed { index, value -> value }
    println(lt33)

    println("\n***** forEachIndexed()")
    ls.forEachIndexed { index, value ->
        if (index % 2 == 0) print("$index : $value, ")
    }
}

fun `processing the continuous range of values as a collection`() {
    println("\n\n***** create IntRange instance")
    val range = IntRange(1, 10)

    println("\n***** use forEach()")
    range.forEach { print("$it ") }
    println()

    (1..10).forEach { print("$it ") }

    println("\n***** properties of IntRange")
    println("first property: ${range.first}")
    println("start property: ${range.start}")
    println("last property: ${range.last}")
    println("step value: ${range.step}")

    println("\n***** range.isEmpty(): ${range.isEmpty()}")
    println("***** range.none(): ${range.none()}")

    println("\n***** range.contains(5): ${range.contains(5)}")

    println("\n***** range.indexOf(7): ${range.indexOf(7)}")
    val position = range.indexOf(7)
    println("***** range.elementAt(position): ${range.elementAt(position)}")
    println("***** range.elementAtOrNull(15): ${range.elementAtOrNull(15)}")

    println("\n***** range.count(): ${range.count()}")
    println("***** range.count(): ${range.count { it % 2 == 1 }}")
    println("***** range.distinct().count(): ${range.distinct().count()}")
    println("***** range.max(): ${range.max()}")
    println("***** range.min(): ${range.min()}")
    println("***** range.sum(): ${range.sum()}")
    println("***** range.average(): ${range.average()}")

    println("\n***** range.joinToString(): ${range.joinToString()}")
    println("***** range.joinToString(): ${range.joinToString(", ")}")

    println("\n***** range.filter() with lambda: ${range.filter { it >= 5 }}")

    val ls = range.toList()
    val ml = range.toMutableList()
    val st = range.toSet()
    val ms = range.toMutableSet()
    val hs = range.toHashSet()
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

    `create a new array by adding indexes`()

    `processing the continuous range of values as a collection`()
}
