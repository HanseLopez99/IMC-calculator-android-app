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

        //Variables
        val intent:Intent = Intent(this, ResultadoActivity::class.java)
        val estaturaTextView:TextView = findViewById(R.id.estatura_text)
        val pesoTextView:TextView = findViewById(R.id.peso_text)
        var resultado:String = "0.0"
        var estatura:Double = 0.0
        var peso:Double = 0.0
        var imc:Double = 0.0
        val df = DecimalFormat("#.##")
        var conclusion:String = ""

        //Boton procesar
        val botonProcesar: Button = findViewById(R.id.procesar_button)
        botonProcesar.setOnClickListener{
            //Inicializaciones

            estatura = estaturaTextView.text.toString().toDouble() / 100
            peso = pesoTextView.text.toString().toDouble() / 2.2
            imc = peso /(estatura*estatura)
            df.roundingMode = RoundingMode.CEILING

            //Calculando conclusion
            if(df.format(imc).toDouble() < 18.5){
                conclusion = "Bajo peso"
            }else if((df.format(imc).toDouble() >= 18.5) && (df.format(imc).toDouble() <= 24.5)) {
                conclusion = "Normal"
            }else if((df.format(imc).toDouble() >= 25.5) && (df.format(imc).toDouble() <= 29.9)){
                conclusion = "Sobrepeso"
            }else if(df.format(imc).toDouble() > 30.0){
                conclusion = "Obesidad"
            }else if(df.format(imc).toDouble() == 0.0){
                "Nulo porque no ha llenado los campos"
            }

            //Resultado Final
            resultado = "Segun tu peso: " + df.format(peso) +" (kg), tu estatura: "+ df.format(estatura)+" (m), tu IMC es: "+df.format(imc)+", lo cual indica: "+conclusion

            //Cambiar activity
            if (estaturaTextView.text.toString().isNotEmpty() && pesoTextView.text.toString().isNotEmpty()){
                intent.putExtra("IMC",resultado)
                intent.putExtra("conclusion", conclusion)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show()
            }
        }

        //LongClick mostar Toast Formula
        botonProcesar.setOnLongClickListener{
            Toast.makeText(this, "Formula: IMC=Peso/(Estatura*Estatura)", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }
}
