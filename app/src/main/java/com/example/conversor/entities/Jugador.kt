package com.example.conversor.entities

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Jugador(var Id: Int = 0,
    var Name: String = "",
    var Pokemones: MutableList<Pokemon> = mutableListOf(),
    var Money: Int = 0): Parcelable{
}