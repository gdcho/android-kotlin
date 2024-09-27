package com.example.lab4davidcho

/*
 * David Cho
 * A01351217
 */

class Human(
    override val race: String = "Human",
    override val baseHealth: Int = 5,
    override val baseSpeed: Int = 5,
    override val backpackSize: Int = 5,
    override val catchphrase: String =""
) : Minion()