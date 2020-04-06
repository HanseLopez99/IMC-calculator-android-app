package com.example.clculodeimcndicedemasacorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val estaturaTextView:TextView = findViewById(R.id.estatura_text)
        val pesoTextView:TextView = findViewById(R.id.peso_text)
        var resultado:String = ""

        val botonProcesar: Button = findViewById(R.id.procesar_button)
        botonProcesar.setOnClickListener{
            var estatura = estaturaTextView.text.toString().toDouble() / 2.2
            var peso = pesoTextView.text.toString().toDouble() / 100
            val imc:Double = peso /(estatura*estatura)

            resultado = "Tu IMC es: " + imc
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()


            val intent:Intent = Intent(this, Resultado::class.java)
            startActivity(intent)
        }

        botonProcesar.setOnLongClickListener{
            Toast.makeText(this, "Formula: IMC=Peso/(Estatura*Estatura)", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }



}
