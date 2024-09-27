package com.example.lab2davidcho

/*
    David Cho
    A01351217

 */

fun main() {
    val arrayList = arrayOf("A", "Quick", "Brown", "Fox", "Went", "Over", "The", "Lazy", "B")
    val arrayList2 = mutableListOf<Int>()
    println("Words: ${arrayList.contentToString()}")
    arrayList.forEach{
        arrayList2.add(it.length)
    }
    println("Words lengths: $arrayList2")
    val longestWords = mutableListOf<String>(); val shortestWords = mutableListOf<String>()
    var i = 0
    while (i < arrayList.size) {
        if (arrayList[i].length == arrayList.maxOf { it.length }) {
            longestWords.add(arrayList[i])
        }
        i++
    }
    for (word in arrayList.reversed()){
        if (word.length == arrayList.minOf { it.length } && !shortestWords.contains(word)) {
            shortestWords.add(word)
        }
        continue
    }
    println("Longest word(s): $longestWords\nShortest word(s): $shortestWords")
}
