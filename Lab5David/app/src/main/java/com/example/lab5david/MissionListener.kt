package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

interface MissionListener {
    fun missionStart(minion: Minion, mission: Mission)
    fun missionProgress(mission: Mission)
    fun missionComplete(minion: Minion, reward: String, mission: Mission)
}
