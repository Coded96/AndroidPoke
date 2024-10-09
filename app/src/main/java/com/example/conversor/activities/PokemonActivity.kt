package com.example.conversor.activities

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor.R
import com.example.conversor.entities.Jugador
import com.example.conversor.entities.Pokemon
import com.example.conversor.entities.PokemonType

class PokemonActivity : AppCompatActivity() {

    private lateinit var playerNameTextView: TextView
    private lateinit var playerHpTextView: TextView
    private lateinit var playerHpProgressBar: ProgressBar
    private lateinit var enemyNameTextView: TextView
    private lateinit var enemyHpTextView: TextView
    private lateinit var enemyHpProgressBar: ProgressBar
    private lateinit var attackButton: Button
    private lateinit var battleLogTextView: TextView
    private lateinit var imgPokemonPropio: ImageView
    private lateinit var imgPokemonSalvaje: ImageView
    private lateinit var combateLayout: LinearLayout

    private lateinit var playerPokemon: Pokemon
    private lateinit var enemyPokemon: Pokemon

    private val wildPokemon: List<String> = listOf("Charmander", "Squirtle", "Bulbasaur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        Toast.makeText(applicationContext, "Página en construcción", Toast.LENGTH_SHORT).show()
        val entrenador: Jugador = intent.getParcelableExtra("entrenador")!!

        initializeViews()
        initializePokemon(entrenador.Pokemones[0])

        updateUI()

        attackButton.setOnClickListener {
            performBattleRound()
        }
    }

    private fun initializePokemon(poke: Pokemon) {
        playerPokemon = poke
        enemyPokemon = createPokemonFromWildness()

        when(poke.Name){
            "Charmander" -> {
                imgPokemonPropio.setImageResource(R.drawable.charmander)
                combateLayout.setBackgroundColor(getColor(R.color.red))
            }
            "Squirtle" -> {
                imgPokemonPropio.setImageResource(R.drawable.squirtle)
                combateLayout.setBackgroundColor(getColor(R.color.blue))
            }
            "Bulbasaur" -> {
                imgPokemonPropio.setImageResource(R.drawable.bulbasaur)
                combateLayout.setBackgroundColor(getColor(R.color.teal_700))
            }
            else -> {
                imgPokemonPropio.setImageResource(R.drawable.pikachu)
                combateLayout.setBackgroundColor(getColor(R.color.yelow))
            }
        }
    }

    private fun initializeViews() {
        playerNameTextView = findViewById(R.id.playerNameTextView)
        playerHpTextView = findViewById(R.id.playerHpTextView)
        playerHpProgressBar = findViewById(R.id.playerHpProgressBar)
        enemyNameTextView = findViewById(R.id.enemyNameTextView)
        enemyHpTextView = findViewById(R.id.enemyHpTextView)
        enemyHpProgressBar = findViewById(R.id.enemyHpProgressBar)
        attackButton = findViewById(R.id.attackButton)
        battleLogTextView = findViewById(R.id.battleLogTextView)
        imgPokemonPropio = findViewById(R.id.imgPokemonPropio)
        imgPokemonSalvaje = findViewById(R.id.imgPokemonSalvaje)
        combateLayout = findViewById(R.id.combateLayout)
    }

    private fun updateUI() {
        playerNameTextView.text = playerPokemon.Name
        playerHpTextView.text = "${playerPokemon.currentHp}/${playerPokemon.maxHp}"
        playerHpProgressBar.progress = (playerPokemon.currentHp * 100) / playerPokemon.maxHp

        enemyNameTextView.text = enemyPokemon.Name
        enemyHpTextView.text = "${enemyPokemon.currentHp}/${enemyPokemon.maxHp}"
        enemyHpProgressBar.progress = (enemyPokemon.currentHp * 100) / enemyPokemon.maxHp
    }


    private fun performBattleRound() {
        val playerDamage = calculateDamage(playerPokemon, enemyPokemon,true)
        enemyPokemon.takeDamage(playerDamage)
        battleLogTextView.append("${playerPokemon.Name} deals $playerDamage damage to ${enemyPokemon.Name}\n")

        if (!enemyPokemon.isDefeated()) {
            val enemyDamage = calculateDamage(enemyPokemon, playerPokemon,false)
            playerPokemon.takeDamage(enemyDamage)
            battleLogTextView.append("${enemyPokemon.Name} deals $enemyDamage damage to ${playerPokemon.Name}\n")
        }

        updateUI()

        if (playerPokemon.isDefeated() || enemyPokemon.isDefeated()) {
            endBattle()
        }
    }

    private fun calculateDamage(attacker: Pokemon, defender: Pokemon, isOwnPokemon: Boolean): Int {
        val baseDamage = (attacker.Attack - defender.Defense / 2).coerceAtLeast(1)
        return (baseDamage * (0.8 + Math.random() * if(isOwnPokemon) 0.8 else 0.4)).toInt()
    }

    private fun endBattle() {
        attackButton.isEnabled = false
        val winner = if (playerPokemon.isDefeated()) enemyPokemon.Name else playerPokemon.Name
        battleLogTextView.append("Battle ended. $winner wins!")
    }

    private fun createPokemonFromWildness(): Pokemon{
        var poke = Pokemon(1, Level= 5, Exp = 0)

        try {
            when (val randomPoke = wildPokemon.random()) {
                "Charmander" -> {
                    poke.Name = randomPoke
                    poke.maxHp = 175
                    poke.Attack = 50
                    poke.Defense = 30
                    poke.Type = PokemonType.FUEGO
                    imgPokemonSalvaje.setImageResource(R.drawable.charmander)
                }

                "Squirtle" -> {
                    poke.Name = randomPoke
                    poke.maxHp = 200
                    poke.Attack = 30
                    poke.Defense = 50
                    poke.Type = PokemonType.AGUA
                    imgPokemonSalvaje.setImageResource(R.drawable.squirtle)
                }

                "Bulbasaur" -> {
                    poke.Name = randomPoke
                    poke.maxHp = 250
                    poke.Attack = 30
                    poke.Defense = 40
                    poke.Type = PokemonType.PLANTA
                    imgPokemonSalvaje.setImageResource(R.drawable.bulbasaur)
                }
            }
        }catch (ex:Exception){
            println("Mensaje de error: ${ex.message}")
        }

        return poke
    }

}