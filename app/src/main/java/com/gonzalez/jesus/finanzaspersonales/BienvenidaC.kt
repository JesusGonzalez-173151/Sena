package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida.*
import kotlinx.android.synthetic.main.activity_bienvenida.btn_next
import kotlinx.android.synthetic.main.activity_bienvenida_c.*

class BienvenidaC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida_c)

        btn_next.setOnClickListener{
            val intent : Intent = Intent(this, Motivacion::class.java)
            startActivity(intent)
        }
    }
}