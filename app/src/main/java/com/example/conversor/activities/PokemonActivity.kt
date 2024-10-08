package com.example.conversor.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.conversor.R
import com.example.conversor.entities.Jugador
import com.example.conversor.fragments.BulbasaurFragment
import com.example.conversor.fragments.CharmanderFragment
import com.example.conversor.fragments.PikachuFragment
import com.example.conversor.fragments.SquirtleFragment

class PokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        Toast.makeText(applicationContext, "Página en construcción", Toast.LENGTH_SHORT).show()
        val entrenador: Jugador = intent.getParcelableExtra("entrenador")!!

        when (intent.getStringExtra("fragmento")) {
            "Charmander" -> {
                replaceFragment(CharmanderFragment.newInstance(entrenador))
            }
            "Squirtle" -> {
                replaceFragment(SquirtleFragment.newInstance(entrenador))
            }
            "Bulbasaur" -> {
                replaceFragment(BulbasaurFragment.newInstance(entrenador))
            }
            "Pikachu" -> {
                replaceFragment(PikachuFragment.newInstance(entrenador))
            }
            else -> Unit
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}