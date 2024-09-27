package com.example.lab4davidcho

/*
 * David Cho
 * A01351217
 */

class Elf(
    override val race: String = "Elf",
    override val baseHealth: Int = 2,
    override val baseSpeed: Int = 8,
    override val backpackSize: Int = 3,
    override val catchphrase: String = "My arrows never miss!"
) : Minion()