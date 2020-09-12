package com.example.ucan_primerejemplo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialogos.*
import kotlinx.android.synthetic.main.dialog_entrada_datos.view.*

class activity_dialogos : AppCompatActivity() {
    var pos=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogos)
        bttoast.setOnClickListener {
            Toast.makeText(this,"Mostrando mensaje",Toast.LENGTH_SHORT).show()
        }
        btdialogo1.setOnClickListener {
            var builder =  AlertDialog.Builder(this);
            builder.setTitle("Eliminando Contacto")
                .setMessage("Esta seguro que desea eliminar este contacto?")

                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"Contacto eliminado correctamente", Toast.LENGTH_SHORT).show()

                })
                .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"Accion Cancelada", Toast.LENGTH_SHORT).show()

                });

            builder.create().show()

        }
        btdiaglo_seleccion.setOnClickListener {
            val items = arrayOf("Español", "Inglés", "Francés")

            val builder = AlertDialog.Builder(this)

            builder.setTitle("Selección")
                .setItems(items) { dialog, item ->
                    Toast.makeText(applicationContext,"Elemento Selecionado==>"+items[ item],Toast.LENGTH_SHORT).show()

                }

            builder.create().show()

        }
        btdialogoRadio.setOnClickListener {
            val items = arrayOf("Español", "Inglés", "Francés")

            val builder = AlertDialog.Builder(this)

            builder.setTitle("Selección")
                .setSingleChoiceItems(items,-1,DialogInterface.OnClickListener { dialogInterface, i ->
                //  Toast.makeText(applicationContext,"Elemento Selecionado==>"+items[ i],Toast.LENGTH_SHORT).show()
                    pos=i
                })
                .setPositiveButton("Ok",DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(applicationContext,"Elemento Selecionado==>"+items[pos],Toast.LENGTH_SHORT).show()

                })


            builder.create().show()

        }

        btdialogo_personalizado.setOnClickListener {
            var dialogo=AlertDialog.Builder(this)
            val inflate=layoutInflater

            val dialog_personalizado=inflate.inflate(R.layout.dialog_entrada_datos,null)
            val textnombre=dialog_personalizado.text_nombre_producto

            dialogo.setView(dialog_personalizado)
            dialogo.setPositiveButton("ok",DialogInterface.OnClickListener { dialogInterface, i ->
               // Toast.makeText(applicationContext,textnombre.text,Toast.LENGTH_SHORT).show()
                textnombre_pro.setText(textnombre.text)
            })
            dialogo.show()

        }

    }
}