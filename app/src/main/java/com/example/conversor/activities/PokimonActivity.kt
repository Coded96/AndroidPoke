package com.example.conversor.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor.R
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.conversor.entities.Pokimon

class PokimonActivity : AppCompatActivity() {

    private lateinit var playerPokemon: Pokimon
    private lateinit var enemyPokemon: Pokimon

    private lateinit var playerNameTextView: TextView
    private lateinit var playerHpTextView: TextView
    private lateinit var playerHpProgressBar: ProgressBar
    private lateinit var enemyNameTextView: TextView
    private lateinit var enemyHpTextView: TextView
    private lateinit var enemyHpProgressBar: ProgressBar
    private lateinit var attackButton: Button
    private lateinit var battleLogTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_pokimon)

            initializePokemon()
            initializeViews()
            updateUI()

            attackButton.setOnClickListener {
                performBattleRound()
            }
        }catch (Ex:Exception){
            println("ex ${Ex.message}")
        }
    }

    private fun initializePokemon() {
        playerPokemon = Pokimon("Pikachu", 100, 100, 55, 40)
        enemyPokemon = Pokimon("Charmander", 90, 90, 52, 43)
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
    }

    private fun updateUI() {
        playerNameTextView.text = playerPokemon.name
        playerHpTextView.text = "${playerPokemon.hp}/${playerPokemon.maxHp}"
        playerHpProgressBar.progress = (playerPokemon.hp * 100) / playerPokemon.maxHp

        enemyNameTextView.text = enemyPokemon.name
        enemyHpTextView.text = "${enemyPokemon.hp}/${enemyPokemon.maxHp}"
        enemyHpProgressBar.progress = (enemyPokemon.hp * 100) / enemyPokemon.maxHp
    }

    private fun performBattleRound() {
        val playerDamage = calculateDamage(playerPokemon, enemyPokemon)
        enemyPokemon.takeDamage(playerDamage)
        battleLogTextView.append("${playerPokemon.name} deals $playerDamage damage to ${enemyPokemon.name}\n")

        if (!enemyPokemon.isDefeated()) {
            val enemyDamage = calculateDamage(enemyPokemon, playerPokemon)
            playerPokemon.takeDamage(enemyDamage)
            battleLogTextView.append("${enemyPokemon.name} deals $enemyDamage damage to ${playerPokemon.name}\n")
        }

        updateUI()

        if (playerPokemon.isDefeated() || enemyPokemon.isDefeated()) {
            endBattle()
        }
    }

    private fun calculateDamage(attacker: Pokimon, defender: Pokimon): Int {
        val baseDamage = (attacker.attack - defender.defense / 2).coerceAtLeast(1)
        return (baseDamage * (0.8 + Math.random() * 0.4)).toInt()
    }

    private fun endBattle() {
        attackButton.isEnabled = false
        val winner = if (playerPokemon.isDefeated()) enemyPokemon.name else playerPokemon.name
        battleLogTextView.append("Battle ended. $winner wins!")
    }
}