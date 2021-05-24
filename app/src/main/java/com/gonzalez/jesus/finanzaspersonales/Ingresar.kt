package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_ingresar.*
import com.gonzalez.jesus.finanzaspersonales.EgresosView

class Ingresar : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)


        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al usuarioGmail
        usuario = FirebaseAuth.getInstance()


        btn_ingresos.setOnClickListener{
            guardaringreso()
        }

        btn_vistaIngresos.setOnClickListener{
            val intent: Intent = Intent(this, IngresosView::class.java)
            startActivity(intent)
        }
    }

    private fun guardaringreso(){
        var tipoingreso = edit_ingreso.text.toString()
        var cantidad = ingreso_cantidad.text.toString()
        var nota = igr_nota.text.toString()

        val ingresos = hashMapOf(

            "cantidad" to cantidad,
            "nota" to nota,
            "tipo" to tipoingreso,
            "email" to usuario.currentUser?.email)


        storage.collection("ingresos").add(ingresos).addOnSuccessListener {
            Toast.makeText(this,"Ingreso agregado", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }

    }
}