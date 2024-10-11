package com.example.conversor.services

import android.content.Context
import android.view.View
import com.example.conversor.entities.MovimientosPokemon
import com.example.conversor.entities.Pokemon
import com.example.conversor.entities.PokemonType

class PokemonService {
    companion object{
        var LOCALFILENAME: String = "PLAYER_INFO"
        var Movements: MutableList<MovimientosPokemon> = mutableListOf()
        var WildPokemons: MutableList<Pokemon> = mutableListOf()
        fun initializePokemonMovements(){
            Movements.add(MovimientosPokemon("Placaje", PokemonType.NORMAL, 10, 80, 40))
            Movements.add(MovimientosPokemon("Arañazo", PokemonType.NORMAL, 15, 80, 35))
            Movements.add(MovimientosPokemon("Relámpago", PokemonType.ELECTRICO, 25, 90, 40))
            Movements.add(MovimientosPokemon("Bola de fuego", PokemonType.FUEGO, 30, 70, 25))
            Movements.add(MovimientosPokemon("Rayo de agua", PokemonType.AGUA, 20, 85, 30))
            Movements.add(MovimientosPokemon("Hoja afilada", PokemonType.PLANTA, 30, 100, 25))
        }

        fun initializeWildPokemon(){
            WildPokemons.add(Pokemon(Id = 1, Name = "Bulbasaur", Type = PokemonType.PLANTA, Attack = 25, Defense = 55, maxHp = 150))
            WildPokemons.add(Pokemon(Id = 4, Name = "Squirtle", Type = PokemonType.AGUA, Attack = 35, Defense = 25, maxHp = 120))
            WildPokemons.add(Pokemon(Id = 7, Name = "Charmander", Type = PokemonType.FUEGO, Attack = 50, Defense = 25, maxHp = 100))
            WildPokemons.add(Pokemon(Id = 11, Name = "Pikachu", Type = PokemonType.ELECTRICO, Attack = 40, Defense = 40, maxHp = 110))
        }

        fun readDataFromLocal(v: View, fileName: String): String{
            try {
                val dataStream = v.context.openFileInput(fileName)
                var contenido = dataStream.bufferedReader().use { it.readText() }
                dataStream.close()
                return contenido
            } catch (ex: Exception){
                println("Error en readDataFromLocal: ${ex.message}")
            }
            return ""
        }

        fun writeDataFromLocal(v: View, fileName: String, info: String){
            try {
                val dataStream = v.context.openFileOutput(fileName, Context.MODE_PRIVATE)
                dataStream.write(info.toByteArray())

                dataStream.close()
            } catch (ex: Exception){
                println("Error en writeDataFromLocal: ${ex.message}")
            }
        }
    }
}