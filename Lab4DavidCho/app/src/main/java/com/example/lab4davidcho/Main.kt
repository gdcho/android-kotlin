package com.example.lab4davidcho

/*
 * David Cho
 * A01351217
 */

fun main() {

    val dwarf = Dwarf()
    val elf = Elf()
    val human = Human()

    val missionListener = object : MissionListener {
        override fun missionStart(minion: Minion) {
            when (minion) {
                is Dwarf -> println("${minion.catchphrase}\n" +
                        "\nA Dwarf was sent off to gather some resources!")
                is Elf -> println("${minion.catchphrase}\n" +
                        "\nAn Elf started a new hunt!")
                is Human -> println("${minion.catchphrase}\n" +
                         "\nA Human was sent off to gather some resources!")
            }
        }

        override fun missionProgress() {
            println("""
                    ...
                    ...
                    ...
                """.trimIndent())
        }

        override fun missionComplete(minion: Minion, result: String) {
            when (minion) {
                is Dwarf -> println("A Dwarf has returned from gathering, and found $result!\n")
                is Elf -> println("An Elf has returned from a hunt, and found a $result!\n")
                is Human -> println("A Human has returned from gathering, and found $result!\n")
            }
        }
    }

    val dwarfGather = Gather(dwarf)
    val elfHunt = Hunt(elf)
    val humanGather = Gather(human)


    dwarfGather.start(missionListener)
    elfHunt.start(missionListener)
//    humanGather.start(missionListener)


}