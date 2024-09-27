package com.example.lab4davidcho

/*
 * David Cho
 * A01351217
 */

interface MissionListener {
    fun missionStart(minion: Minion)
    fun missionProgress()
    fun missionComplete(minion: Minion, reward: String)

}