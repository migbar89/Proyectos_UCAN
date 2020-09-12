package com.example.ucan_primerejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btactivity2.setOnClickListener {
            compartir.cadena=ctcadena1.text.toString()
            var intent=Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
        btsuma.setOnClickListener {
           if( ctvalor1.text.toString().length==0 || ctvalor2.text.toString().length==0)
           {
               Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }
            //obtener el valor de las cajas de texto
            var valor1=ctvalor1.text.toString().toDouble()
            var valor2=ctvalor2.text.toString().toDouble()

            //Realizar la operacion
            var resultado=valor1+valor2;

            //Mostrar el resultado
           // Toast.makeText(this, "suma="+resultado, Toast.LENGTH_SHORT).show()
            tvresultado.setText("Resultado="+resultado.toString())

        }

        Multiplicar.setOnClickListener {
            if( ctvalor1.text.toString().length==0 || ctvalor2.text.toString().length==0)
            {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //obtener el valor de las cajas de texto
            var valor1=ctvalor1.text.toString().toDouble()
            var valor2=ctvalor2.text.toString().toDouble()

            //Realizar la operacion
            var resultado=valor1*valor2;

            //Mostrar el resultado
            // Toast.makeText(this, "sum="+resultado, Toast.LENGTH_SHORT).show()
            tvresultado.setText("Multiplicacion="+resultado.toString())

        }



    }

    override fun onPause() {
        Toast.makeText(this, "Actividad 1 On pause", Toast.LENGTH_SHORT).show()

        super.onPause()
    }

    override fun onRestart() {
        Toast.makeText(this, "Actividad 1 On Restart", Toast.LENGTH_SHORT).show()
        ctcadena1.setText(compartir.cadena)
        super.onRestart()
    }
}