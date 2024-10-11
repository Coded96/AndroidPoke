package com.example.conversor

import android.content.Intent
import android.os.Bundle
import android.os.storage.StorageManager
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
import com.example.conversor.services.PokemonService

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

        PokemonService.initializePokemonMovements()
        PokemonService.initializeWildPokemon()

        entrenador = initializeTrainer()

        onClickOtherActivities()
        onTrainerNameChanged()

    }

    private fun onClickOtherActivities(){
        imgBulbasaur.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                entrenador.Pokemones.add(PokemonService.WildPokemons.filter { it.Id == 1 }.first())

                startActivityPokemon()
            }
        }
        imgSquirtle.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                entrenador.Pokemones.add(PokemonService.WildPokemons.filter { it.Id == 4 }.first())

                startActivityPokemon()
            }
        }
        imgCharmander.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                entrenador.Pokemones.add(PokemonService.WildPokemons.filter { it.Id == 7 }.first())

                startActivityPokemon()
            }
        }
        imgPikachu.setOnClickListener {
            if(entrenador.Name != "") {
                entrenador.Pokemones.clear()
                entrenador.Pokemones.add(PokemonService.WildPokemons.filter { it.Id == 11 }.first())

                startActivityPokemon()
            }
        }
    }
    private fun onTrainerNameChanged(){
        try {
            txtTrainerName.setText(entrenador.Name)
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

    private fun initializeTrainer(): Jugador{
        var jugador = Jugador()
        var infoPlayer = PokemonService.readDataFromLocal(window.decorView.rootView, PokemonService.LOCALFILENAME)
        if(infoPlayer != ""){
            jugador = Jugador(Name = infoPlayer.split('#')[0], Money = infoPlayer.split('#')[1].toInt())
        }
        return jugador
    }

    private fun startActivityPokemon(){
        PokemonService.writeDataFromLocal(window.decorView.rootView, PokemonService.LOCALFILENAME, "${entrenador.Name}#${entrenador.Money}")

        val intent = Intent(this, PokemonActivity::class.java)
        intent.putExtra("entrenador", entrenador)
        startActivity(intent)
    }
}
