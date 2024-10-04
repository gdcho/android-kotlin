package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

abstract class Mission(val minion: Minion, val item: Item? = null, val companion: Companion? = null) {
    fun start(missionListener: MissionListener) {
        missionListener.missionStart(this.minion, this)
        missionListener.missionProgress(this)
        missionListener.missionComplete(this.minion,
            this.reward(this.determineMissionTime()), this)
    }

    abstract fun determineMissionTime(): Int
    abstract fun reward(time: Int): String
}

