package com.example.conversor.entities

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.io.Serializable

@Parcelize
data class Pokemon(var Id: Int = 0,
    var Name: String = "",
    var Level: Int = 1,
    var Type: PokemonType = PokemonType.NORMAL,
    var SecondaryType: PokemonType = PokemonType._NONE,
    /*var Image: ImageView? = null,*/
    var Exp: Int = 0,
    var Attack: Int = 0,
    var Defense: Int = 0): Parcelable {
}