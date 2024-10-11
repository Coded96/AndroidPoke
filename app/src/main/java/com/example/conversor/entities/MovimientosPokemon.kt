package com.example.conversor.entities

data class MovimientosPokemon(
    val nombre: String,
    val tipo: PokemonType,
    val poder: Int,
    val precision: Int,
    val puntosPoder: Int
)