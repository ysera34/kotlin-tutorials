package sequence

import kotlin.streams.asStream
import kotlin.streams.toList

fun main(args: Array<String>) {
    val ls1 = listOf(1, 2, 3, 4, 5).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nCollection Sequence: $ls1\n")

    val ls2 = listOf(1, 2, 3, 4, 5).asSequence().asStream()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nCollection Stream: $ls2\n")

    val ar1 = arrayOf(1, 2, 3, 4, 5).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nArray Sequence: $ar1\n")

    val ar2 = arrayOf(1, 2, 3, 4, 5).asSequence().asStream()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nArray Stream: $ar2\n")

    val ra1 = (1..5).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nRange Sequence: $ra1\n")

    val ra2 = (1..5).asSequence().asStream()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nRange Stream: $ra2\n")


    val ls11 = listOf(1, 2, 3, 4, 5)
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
    println("\nCollection function chaining called: $ls11\n")

    val seq1 = listOf(1, 2, 3, 4, 5).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
    println("\nNo termination function: $seq1\n")

    val seq2 = listOf(1, 2, 3, 4, 5).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
    println("\nWith termination function: $seq2\n")

    `generate sequence`()
}

fun `generate sequence`() {
    var count = 0

    val seq1 = generateSequence(count) { it + 1 }
    val seq2 = seq1.takeWhile { it <= 5 }

    println("generateSequence(): ${seq2.sum()}")
    println("generateSequence(): ${seq2.toList()}")
    println()

    val seq3 = sequenceOf(1, 2, 3, 4, 5)

    println("sequenceOf(): ${seq3.sum()}")
    println("sequenceOf(): ${seq3.toList()}")
    println()

    val seq4 = generateSequence {
        (count++).takeIf { it <= 5 }
    }
    println("generateSequence(): ${seq4.sum()}")
    // java.lang.IllegalStateException: This sequence can be consumed only once.
    // println("generateSequence(): ${seq4.toList()}")
}