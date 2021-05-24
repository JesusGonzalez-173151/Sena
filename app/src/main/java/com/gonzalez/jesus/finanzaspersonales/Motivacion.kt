package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_motivacion.*
import java.security.Principal

class Motivacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivacion)

        btn_next.setOnClickListener{
            val intent: Intent = Intent(this, Pincipal::class.java)
            startActivity(intent)

        }

        boton_otro.setOnClickListener{
            val intent: Intent = Intent(this, motivacion2::class.java)
            startActivity(intent)
        }
    }
}