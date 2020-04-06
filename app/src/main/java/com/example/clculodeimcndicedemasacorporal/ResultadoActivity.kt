package com.example.clculodeimcndicedemasacorporal

import android.widget.Toast
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        val resultadoTextView:TextView = findViewById(R.id.resultado_text)
        val rollButton: Button = findViewById(R.id.resultado_button)
        rollButton.text = "Mostrar Resultado"
        rollButton.setOnClickListener{
            resultadoTextView.text = getIntent().getStringExtra("IMC")
        }
    }


}
