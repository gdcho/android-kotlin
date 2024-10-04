package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

import kotlin.properties.Delegates

class Hunt(minion: Minion,item: Item?,companion: Companion?): Mission(minion,item, companion), Repeatable {
    override var repeatNum: Int by Delegates.vetoable(3) { _, _, newValue ->
        if (newValue <= 3) {
            true
        } else {
            println("A minion cannot repeat a hunt more than 3 times! Repeating a hunt 3 times...\n")
            false
        }
    }
    override fun determineMissionTime(): Int {
        return (this.minion.baseHealth + this.minion.baseSpeed +  (this.item?.timeModifier ?: 0))* (0..4).random()
    }

    override fun reward(time: Int): String {
        if (this.companion != null) return this.companion.huntReward(time)

        return when (time) {
            in 11..20 -> "mouse"
            in 21..30 -> "fox"
            in 31..40 -> "buffalo"
            in 41..60 -> "dinosaur"
            else -> "nothing"
        }
    }

    override fun repeat(time: Int, missionListener: MissionListener) {
        this.repeatNum = time
        for (i in 1..this.repeatNum) {
            this.start(missionListener)
        }
    }
}