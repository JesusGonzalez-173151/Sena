package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_tarjeta_registro.*
import luna.joel.sena.TarjetasView

class TarjetaRegistro : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarjeta_registro)

        storage = FirebaseFirestore.getInstance()

        usuario = FirebaseAuth.getInstance()

        btn_next.setOnClickListener{
            guardarTarjeta()
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnverTarjetas.setOnClickListener {
            val intent: Intent = Intent(this, TarjetasView::class.java)
            startActivity(intent)
        }
    }

    private fun guardarTarjeta(){

        var nombre = editTextPersonName.text.toString()
        var numTarjeta = numeroTarjeta.text.toString()
        var mes = editMonth.text.toString()
        var tipo = type_tarjet.text.toString()


        val tarjeta = hashMapOf(

            "nombreTitular" to nombre,
            "fechaExp" to mes,
            "numeroTarjeta" to numTarjeta,
            "email" to usuario.currentUser?.email,
            "tipoTarjeta" to tipo)


        storage.collection("tarjetero").add(tarjeta).addOnSuccessListener {
            Toast.makeText(this,"Ingreso agregado", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }
    }
}