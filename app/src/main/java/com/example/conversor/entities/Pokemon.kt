package com.example.conversor.entities

import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.io.Serializable

@Parcelize
data class Pokemon(
        var Id: Int = 0,
        var Name: String = "",
        var Level: Int = 1,
        var Type: PokemonType = PokemonType.NORMAL,
        var SecondaryType: PokemonType = PokemonType._NONE,
        var Exp: Int = 0,
        var Attack: Int = 0,
        var Defense: Int = 0,
        var maxHp: Int = 100,
        var currentHp: Int = maxHp,
        var Movements: @RawValue MutableList<MovimientosPokemon> = mutableListOf()): Parcelable {


    fun takeDamage(damage: Int) {
        currentHp -= damage
        if (currentHp < 0) currentHp = 0
    }
    fun isDefeated(): Boolean = currentHp <= 0

    fun escalarVida(nivel: Int) {
        maxHp += ((maxHp * 2 * nivel) / 100) + nivel + 10
    }

    fun escalarAtaque(nivel: Int) {
        Attack += ((Attack * 2 * nivel) / 100) + 5
    }

    fun escalarDefensa(nivel: Int) {
        Defense += ((Defense * 2 * nivel) / 100) + 5
    }
}