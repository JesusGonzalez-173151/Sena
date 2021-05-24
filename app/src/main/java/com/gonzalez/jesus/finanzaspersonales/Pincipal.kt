package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_ingresar.*
import kotlinx.android.synthetic.main.activity_pincipal.*

class Pincipal : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pincipal)


        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        btn_ingresos.setOnClickListener {
            val intent: Intent= Intent(this, Ingresar::class.java)
            startActivity(intent)
        }

        btn_egresar.setOnClickListener {
            val intent: Intent= Intent(this, Egresar::class.java)
            startActivity(intent)
        }

        btn_sena_pro.setOnClickListener {
            val intent: Intent= Intent(this, TarjetaRegistro::class.java)
            startActivity(intent)
        }


    }
}