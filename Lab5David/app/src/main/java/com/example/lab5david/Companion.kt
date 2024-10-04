package com.example.lab5david

class Companion {
    fun huntReward(amount:Int):String {
        if (amount in (11..20)) return "fish"
        if (amount in (21..30)) return "forest bear"
        if (amount in (31..40)) return "orc"
        if (amount in (41..60)) return "troll"
        return "nothing"
    }
}