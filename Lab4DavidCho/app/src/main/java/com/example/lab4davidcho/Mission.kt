package com.example.lab4davidcho

/*
 * David Cho
 * A01351217
 */

abstract class Mission(protected val minion: Minion)
{
    fun start(missionListener: MissionListener) {
        missionListener.missionStart(minion)
        missionListener.missionProgress()
        val time = determineMissionTime()
        val result = reward(time)
        missionListener.missionComplete(minion, result)
    }
    protected abstract fun determineMissionTime(): Int
    protected abstract fun reward(time: Int): String
}