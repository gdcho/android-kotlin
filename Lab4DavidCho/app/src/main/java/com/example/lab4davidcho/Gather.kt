package com.example.lab4davidcho

class Gather(minion: Minion) : Mission(minion) {
    override fun determineMissionTime(): Int {
        return minion.backpackSize * minion.baseSpeed * (0..4).random()
    }

    override fun reward(time: Int): String {
        return when (time) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..50 -> "gold"
            else -> "nothing"
        }
    }
}