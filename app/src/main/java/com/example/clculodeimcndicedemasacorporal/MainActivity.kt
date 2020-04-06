package com.example.clculodeimcndicedemasacorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val estaturaTextView:TextView = findViewById(R.id.estatura_text)
        val pesoTextView:TextView = findViewById(R.id.peso_text)
        var resultado:String = ""

        val botonProcesar: Button = findViewById(R.id.procesar_button)
        botonProcesar.setOnClickListener{
            var estatura = estaturaTextView.text.toString().toDouble() / 100
            var peso = pesoTextView.text.toString().toDouble() / 2.2
            val estaturaTotal:Double = estatura*estatura
            val imc:Double = peso /estaturaTotal
            val df = DecimalFormat("#.##")
            var conclusion:String = ""
            df.roundingMode = RoundingMode.CEILING

            if(df.format(imc).toDouble() < 18.5){
                conclusion = "Bajo peso"
            }else if((df.format(imc).toDouble() >= 18.5) && (df.format(imc).toDouble() <= 24.5)) {
                conclusion = "Normal"
            }else if((df.format(imc).toDouble() >= 25.5) && (df.format(imc).toDouble() <= 29.9)){
                conclusion = "Sobrepeso"
            }else if(df.format(imc).toDouble() > 30.0){
                conclusion = "Obesidad"
            }

            resultado = "Segun tu peso: " + df.format(peso) +", tu estatura: "+ df.format(estatura)+", tu IMC es: "+df.format(imc)+", lo cual indica: "+conclusion

            val intent:Intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("IMC",resultado)
            startActivity(intent)

        }

        botonProcesar.setOnLongClickListener{
            Toast.makeText(this, "Formula: IMC=Peso/(Estatura*Estatura)", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }



}
