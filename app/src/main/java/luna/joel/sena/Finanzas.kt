package luna.joel.sena


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_finanzas.*


class Finanzas : AppCompatActivity() {


    var adaptador: FinanzasAdapter? = null
    var finanzas =  ArrayList<Finanza>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finanzas)

        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        fillFinanzas()

            adaptador = FinanzasAdapter(this, finanzas)
            gridviewFinanzas.adapter = adaptador

    }

    fun fillFinanzas(){

        storage.collection("ingresos").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {
                    finanzas =  ArrayList()
                    finanzas!!.add(Finanza(it.getString("tipo")!!,it.getString("cantidad")!!,it.getString("nota")!!))

           }
                adaptador = FinanzasAdapter(this, finanzas)
                gridviewFinanzas.adapter = adaptador
        }
    }
}