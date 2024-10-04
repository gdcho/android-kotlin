package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

interface Repeatable{
    abstract var repeatNum : Int
    fun repeat(time:Int, missionListener: MissionListener)
}
