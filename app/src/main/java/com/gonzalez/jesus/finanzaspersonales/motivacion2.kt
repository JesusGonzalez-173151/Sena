package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_motivacion2.*

class motivacion2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivacion2)

        btn_next.setOnClickListener{
            val intent: Intent = Intent(this, Pincipal::class.java)
            startActivity(intent)
        }
    }
}