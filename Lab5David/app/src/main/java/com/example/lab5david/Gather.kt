package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

class Gather(minion: Minion, item: Item?, companion: Companion?): Mission(minion,item, companion){
    override fun determineMissionTime(): Int {
        return (this.minion.backpackSize + this.minion.baseSpeed + (this.item?.timeModifier ?: 0)) * (0..4).random()
    }

    override fun reward(time: Int): String {
        return when (time) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..44 -> "gold"
            in 45..60 -> "diamond"
            else -> "nothing"
        }
    }
}