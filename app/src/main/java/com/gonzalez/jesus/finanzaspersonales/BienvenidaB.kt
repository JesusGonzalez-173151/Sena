package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida.*
import kotlinx.android.synthetic.main.activity_bienvenida.btn_next
import kotlinx.android.synthetic.main.activity_bienvenida_b.*

class BienvenidaB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida_b)

        btn_next.setOnClickListener{
            val intent : Intent = Intent(this, BienvenidaC::class.java)
            startActivity(intent)
        }
    }
}