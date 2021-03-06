package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_email_login.*

class EmailLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_login)

        auth = FirebaseAuth.getInstance()

        btn_ingresar.setOnClickListener {
            valida_ingreso()
        }

    }

    private fun valida_ingreso() {

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if (!correo.isNullOrBlank() && !contra.isNullOrBlank()) {
            ingresarFirebase(correo, contra)

        } else {
            Toast.makeText(
                this, "Ingresar datos",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun ingresarFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                    val intent: Intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }
}