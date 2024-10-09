package com.example.conversor

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor.activities.PokemonActivity
import com.example.conversor.entities.Jugador
import com.example.conversor.entities.Pokemon
import com.example.conversor.entities.PokemonType

class MainActivity : AppCompatActivity() {
    lateinit var imgCharmander: ImageView
    lateinit var imgSquirtle: ImageView
    lateinit var imgBulbasaur: ImageView
    lateinit var imgPikachu: ImageView
    lateinit var txtTrainerName: EditText
    lateinit var entrenador: Jugador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgCharmander = findViewById<ImageView>(R.id.imgCharmander)
        imgSquirtle = findViewById<ImageView>(R.id.imgSquirtle)
        imgBulbasaur = findViewById<ImageView>(R.id.imgBulbasaur)
        imgPikachu = findViewById<ImageView>(R.id.imgPikachu)
        txtTrainerName = findViewById(R.id.txtTrainerName)

        entrenador = Jugador()
        entrenador.Id = 1

        onClickOtherActivities()
        onTrainerNameChanged()

    }

    private fun onClickOtherActivities(){
        imgCharmander.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                var poke = Pokemon()
                poke.Id = 1
                poke.Name = "Charmander"
                poke.Type = PokemonType.FUEGO
                poke.Attack = 50
                poke.Defense = 25
                entrenador.Pokemones.add(poke)

                startActivityPokemon()
            }
        }
        imgSquirtle.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                var poke = Pokemon()
                poke.Id = 2
                poke.Name = "Squirtle"
                poke.Type = PokemonType.AGUA
                poke.Attack = 35
                poke.Defense = 25
                entrenador.Pokemones.add(poke)

                startActivityPokemon()
            }
        }
        imgBulbasaur.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                var poke = Pokemon()
                poke.Id = 3
                poke.Name = "Bulbasaur"
                poke.Type = PokemonType.PLANTA
                poke.Attack = 25
                poke.Defense = 55
                poke.maxHp = 150
                entrenador.Pokemones.add(poke)

                startActivityPokemon()
            }
        }
        imgPikachu.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                var poke = Pokemon()
                poke.Id = 4
                poke.Name = "Pikachu"
                poke.Type = PokemonType.ELECTRICO
                poke.Attack = 40
                poke.Defense = 40
                entrenador.Pokemones.add(poke)

                startActivityPokemon()
            }
        }
    }
    private fun onTrainerNameChanged(){
        try {
            txtTrainerName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    try{
                        print("before")
                    } catch (exBefore: Exception){
                        print("ERROR EN beforeTextChanged: " + exBefore.message)
                    }
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    try{
                        print("ontext")
                    } catch (exOnChanged: Exception){
                        print("ERROR EN onTextChanged: " + exOnChanged.message)
                    }
                }

                override fun afterTextChanged(text: Editable?) {
                    try{
                        entrenador.Name = text.toString()
                    } catch (exAfter: Exception){
                        print("ERROR EN afterTextChanged: " + exAfter.message)
                    }
                }
            })
        } catch (ex: Exception){
            print("ERROR EN onTrainerNameChanged: " + ex.message)
        }
    }

    private fun startActivityPokemon(){
        val intent = Intent(this, PokemonActivity::class.java)
        intent.putExtra("entrenador", entrenador)
        startActivity(intent)
    }
}
