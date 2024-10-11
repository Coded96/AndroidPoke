package com.example.conversor.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor.R
import com.example.conversor.entities.Jugador
import com.example.conversor.entities.Pokemon
import com.example.conversor.entities.PokemonType
import kotlinx.coroutines.*

class PokemonActivity : AppCompatActivity() {

    private lateinit var txtPokePlayerName: TextView
    private lateinit var txtPokePlayerLvl: TextView
    private lateinit var txtPokePlayerHp: TextView
    private lateinit var progbarPokePlayer: ProgressBar
    private lateinit var txtPokeEnemyName: TextView
    private lateinit var txtPokeEnemyLvl: TextView
    private lateinit var txtPokeEnemyHp: TextView
    private lateinit var progbarPokeEnemy: ProgressBar
    private lateinit var attackButton: Button
    private lateinit var battleLogTextView: TextView
    private lateinit var scrollView: ScrollView
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

        txtPokePlayerName.text = playerPokemon.Name
        txtPokePlayerLvl.text = "Lv ${playerPokemon.Level}"
        txtPokeEnemyName.text = enemyPokemon.Name
        txtPokeEnemyLvl.text = "Lv ${enemyPokemon.Level}"

        attackButton.setOnClickListener {
            performBattleRound()
        }

        battleLogTextView.styledText("Un ${enemyPokemon.Name} salvaje apareció")
        battleLogTextView.styledText("${playerPokemon.Name} está listo para el combate. ¿Que debería hacer?")
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
        txtPokePlayerName = findViewById(R.id.txtPokePlayerName)
        txtPokePlayerLvl = findViewById(R.id.txtPokePlayerLvl)
        txtPokePlayerHp = findViewById(R.id.txtPokePlayerHp)
        progbarPokePlayer = findViewById(R.id.progbarPokePlayer)

        txtPokeEnemyName = findViewById(R.id.txtPokeEnemyName)
        txtPokeEnemyLvl = findViewById(R.id.txtPokeEnemyLvl)
        txtPokeEnemyHp = findViewById(R.id.txtPokeEnemyHp)
        progbarPokeEnemy = findViewById(R.id.progbarPokeEnemy)

        attackButton = findViewById(R.id.attackButton)
        battleLogTextView = findViewById(R.id.battleLogTextView)
        scrollView = (battleLogTextView.parent as ScrollView)

        imgPokemonPropio = findViewById(R.id.imgPokemonPropio)
        imgPokemonSalvaje = findViewById(R.id.imgPokemonSalvaje)

        combateLayout = findViewById(R.id.combateLayout)
    }

    private fun updateUI() {
        txtPokePlayerHp.text = "${playerPokemon.currentHp}/${playerPokemon.maxHp}"
        progbarPokePlayer.progress = (playerPokemon.currentHp * 100) / playerPokemon.maxHp

        txtPokeEnemyHp.text = "${enemyPokemon.currentHp}/${enemyPokemon.maxHp}"
        progbarPokeEnemy.progress = (enemyPokemon.currentHp * 100) / enemyPokemon.maxHp
    }


    private fun performBattleRound() {
        val playerDamage = calculateDamage(playerPokemon, enemyPokemon,true)
        enemyPokemon.takeDamage(playerDamage)
        battleLogTextView.styledText("${playerPokemon.Name} deals $playerDamage damage to ${enemyPokemon.Name}")

        if (!enemyPokemon.isDefeated()) {
            val enemyDamage = calculateDamage(enemyPokemon, playerPokemon,false)
            playerPokemon.takeDamage(enemyDamage)
            battleLogTextView.styledText("${enemyPokemon.Name} deals $enemyDamage damage to ${playerPokemon.Name}")
        }

        updateUI()

        if (playerPokemon.isDefeated() || enemyPokemon.isDefeated()) {
            endBattle()
        }
    }

    private fun calculateDamage(attacker: Pokemon, defender: Pokemon, isOwnPokemon: Boolean): Int {
        val baseDamage = (attacker.Attack - defender.Defense / 2).coerceAtLeast(1)
        return (baseDamage * (0.8 + Math.random() * if(isOwnPokemon) 0.8 else 0.2)).toInt()
    }

    private fun endBattle() {
        attackButton.isEnabled = false
        val winner = if (playerPokemon.isDefeated()) enemyPokemon.Name else playerPokemon.Name
        battleLogTextView.styledText("Battle ended. $winner wins!")
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

    private fun TextView.styledText(text: String){
        for (char in text) {
            battleLogTextView.append(char.toString()) // Añade cada letra una a una
            scrollView.post {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN) // Hace scroll hacia abajo
            }
        }
        battleLogTextView.append("\n") // Al final añade un salto de línea
    }
}