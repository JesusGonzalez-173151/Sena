package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicio()

    }

     fun inicio(){

        val handler = Handler()
        handler.postDelayed({ // TODO: Your application init goes here.
            val intent = Intent(this, BienvenidaA::class.java)
            startActivity(intent)
            this.finish()
        }, 4000)

    }

}