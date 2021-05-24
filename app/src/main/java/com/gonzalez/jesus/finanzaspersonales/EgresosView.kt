package com.gonzalez.jesus.finanzaspersonales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresos_view.*


class EgresosView : AppCompatActivity() {

    var adaptador: FinanzasAdapter? = null
    var egresos =  ArrayList<Finanza>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egresos_view)

        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        fillFinanzas()

        if(!egresos.isEmpty()) {
            adaptador = FinanzasAdapter(this, egresos)
            egresos_view.adapter = adaptador
        }
    }

    fun fillFinanzas(){

        storage.collection("egresos").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {
                    var tipo = ArrayList<String>()
                    var cantidad = ArrayList<String>()
                    var nota = ArrayList<String>()

                    if(it.getString("tipo") != null){
                        tipo.add(it.toString())
                    }

                    else if(it.getString("cantidad") != null){
                        cantidad.add(it.toString())
                    }

                    else if(it.getString("nota") != null){
                        nota.add(it.toString())
                    }
                    egresos!!.add(Finanza(tipo!!,cantidad!!,nota!!))

                }
                adaptador = FinanzasAdapter(this, egresos)
                egresos_view.adapter = adaptador
            }
    }
}