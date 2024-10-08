package com.example.conversor.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.conversor.R
import com.example.conversor.utils.Conversores.Companion.TipoConversion
import com.example.conversor.utils.Conversores.Companion.convertirDolar
import com.example.conversor.utils.Conversores.Companion.convertirEuro
import com.example.conversor.utils.Conversores.Companion.convertirLibra
import com.example.conversor.utils.Conversores.Companion.convertirPesoMexicano
import com.example.conversor.utils.Conversores.Companion.convertirYen
import com.example.conversor.utils.Conversores.Companion.convertirYuan
import com.example.conversor.utils.Conversores.Companion.reconvertirDolar
import com.example.conversor.utils.Conversores.Companion.reconvertirEuro
import com.example.conversor.utils.Conversores.Companion.reconvertirLibra
import com.example.conversor.utils.Conversores.Companion.reconvertirPesoMexicano
import com.example.conversor.utils.Conversores.Companion.reconvertirYen
import com.example.conversor.utils.Conversores.Companion.reconvertirYuan

class ConversorActivity : AppCompatActivity() {
    lateinit var firstVal: EditText
    lateinit var secondVal: EditText
    lateinit var ddlUnidades: Spinner
    lateinit var ddlUnidades2: Spinner
    lateinit var tapMe: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)

        firstVal = findViewById<EditText>(R.id.txtFirstValue)
        secondVal = findViewById<EditText>(R.id.txtSecondValue)
        ddlUnidades = findViewById<Spinner>(R.id.ddlUnidades)
        ddlUnidades2 = findViewById<Spinner>(R.id.ddlUnidades2)
        tapMe = findViewById<ImageView>(R.id.tapme)
        Glide.with(this).load(R.drawable.clickme).into(tapMe)

        Toast.makeText(applicationContext, "Versión en desarrollo \n\rPor David", Toast.LENGTH_SHORT).show()

        onClickOtherActivities()

        val data = TipoConversion.values().toList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        ddlUnidades.adapter = adapter
        ddlUnidades2.adapter = adapter

        loadValues(firstVal, secondVal)
    }

    private fun loadValues(firstVal: EditText, secondVal: EditText) {
        var isUpdating = false

        firstVal?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (!isUpdating) {
                    isUpdating = true // Establece la bandera como verdadera
                    checkUnitSelected(s)
                    isUpdating = false
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        })

        secondVal?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (!isUpdating) {
                    isUpdating = true // Establece la bandera como verdadera
                    checkUnitSelected2(s)
                    isUpdating = false
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    private fun onClickOtherActivities(){
        tapMe.setOnClickListener {
            val intent = Intent(this, ConversorActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkUnitSelected(s: Editable) {
        when (ddlUnidades.selectedItem) {
            TipoConversion.Euro -> secondVal.setText(convertirEuro(s, ddlUnidades2.selectedItem))

            TipoConversion.Dolar -> secondVal.setText(convertirDolar(s, ddlUnidades2.selectedItem))

            TipoConversion.Libra -> secondVal.setText(convertirLibra(s, ddlUnidades2.selectedItem))

            TipoConversion.Yen -> secondVal.setText(convertirYen(s, ddlUnidades2.selectedItem))

            TipoConversion.Yuan -> secondVal.setText(convertirYuan(s, ddlUnidades2.selectedItem))

            TipoConversion.PesoMexicano -> secondVal.setText(convertirPesoMexicano(s, ddlUnidades2.selectedItem))

            else -> secondVal.setText(s.toString())
        }
    }

    fun checkUnitSelected2(s: Editable) {
        when (ddlUnidades2.selectedItem) {
            TipoConversion.Euro -> firstVal.setText(reconvertirEuro(s, ddlUnidades.selectedItem))

            TipoConversion.Dolar -> firstVal.setText(reconvertirDolar(s, ddlUnidades.selectedItem))

            TipoConversion.Libra -> firstVal.setText(reconvertirLibra(s, ddlUnidades.selectedItem))

            TipoConversion.Yen -> firstVal.setText(reconvertirYen(s, ddlUnidades.selectedItem))

            TipoConversion.Yuan -> firstVal.setText(reconvertirYuan(s, ddlUnidades.selectedItem))

            TipoConversion.PesoMexicano -> firstVal.setText(reconvertirPesoMexicano(s, ddlUnidades.selectedItem))

            else -> firstVal.setText(s.toString())
        }
    }
}