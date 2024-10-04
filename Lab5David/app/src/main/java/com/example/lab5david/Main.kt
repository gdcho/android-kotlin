package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

fun main() {
    val missionListener = object : MissionListener {
        override fun missionStart(minion: Minion, mission: Mission) {
            println(minion.catchphrase)
            if (mission is Gather) {
                println("A(n) ${minion.race} was sent off to gather some resources!")
            } else if (mission is Hunt) {
                println("A(n) ${minion.race} started a new hunt!")
            }
        }

        override fun missionProgress(mission: Mission) {
            println(
                """
                    ...
                    ...
                    ...
                """.trimIndent()
            )
        }

        override fun missionComplete(minion: Minion, reward: String, mission: Mission) {
            if (mission is Gather) {
                println("A(n) ${minion.race} has returned from gathering, and found $reward!\n")
            } else if (mission is Hunt) {
                println("A(n) ${minion.race} has returned from a hunt, and found $reward!\n")
            }
        }
    }

    val orc = Orc(Elf())
    val human = Human()

    val humanMission = Hunt(human, null, null)
//    humanMission.repeat(3, missionListener)

    val orcMission = Hunt(orc, Item.NECKLACE, Companion())
    orcMission.repeat(4, missionListener)
}



