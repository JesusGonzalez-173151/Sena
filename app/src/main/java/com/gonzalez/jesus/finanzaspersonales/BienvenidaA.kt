package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida.*

class BienvenidaA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        btn_next.setOnClickListener{
            val intent : Intent = Intent(this, BienvenidaB::class.java)
            startActivity(intent)
        }
    }
}