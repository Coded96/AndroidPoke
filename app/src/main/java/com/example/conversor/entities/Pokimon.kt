package com.example.conversor.entities

data class Pokimon(
    val name: String,
    var hp: Int,
    val maxHp: Int,
    val attack: Int,
    val defense: Int
) {
    fun takeDamage(damage: Int) {
        hp -= damage
        if (hp < 0) hp = 0
    }

    fun isDefeated(): Boolean = hp <= 0
}