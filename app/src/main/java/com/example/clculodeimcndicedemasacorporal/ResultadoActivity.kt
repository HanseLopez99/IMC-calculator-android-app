package com.example.clculodeimcndicedemasacorporal

import android.widget.Toast
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.widget.ImageView

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Variables externas
        var imagen: ImageView
        val resultadoTextView:TextView = findViewById(R.id.resultado_text)
        var conclusion:String = getIntent().getStringExtra("conclusion")
        resultadoTextView.text = getIntent().getStringExtra("IMC")

        //Seleccion de imagen de conclusion
        imagen = findViewById(R.id.result_Image)
        if(conclusion == "Normal"){
            imagen.setImageResource(R.drawable.ic_good)
        }else if(conclusion == "Obesidad"){
            imagen.setImageResource(R.drawable.ic_bad)
        }else if((conclusion == "Bajo peso") || (conclusion == "Sobrepeso")){
            imagen.setImageResource(R.drawable.ic_warning)
        }

        //Boton para regresar
        val button: Button = findViewById(R.id.resultado_button)
        button.text = "Regresar"
        button.setOnClickListener{
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}
