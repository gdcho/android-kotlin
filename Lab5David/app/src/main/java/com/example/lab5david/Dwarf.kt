package com.example.lab5david

/*
 * David Cho
 * A01351217
 */

class Dwarf(
    override val race: String = "Dwarf",
    override val baseHealth: Int = 8,
    override val baseSpeed: Int = 2,
    override val backpackSize: Int = 8,
    override val catchphrase: String = "Where's me trusty ol' hammer?"
) : Minion
