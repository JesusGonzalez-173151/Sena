package luna.joel.sena


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_finanzas.*


class IngresosView : AppCompatActivity() {


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
        if(!finanzas.isEmpty()) {
            adaptador = FinanzasAdapter(this, finanzas)
            gridviewFinanzas.adapter = adaptador
        }
    }

    fun fillFinanzas(){

        storage.collection("ingresos").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {
                    var tipo = ArrayList<String>()
                    var cantidad = ArrayList<String>()
                    var nota = ArrayList<String>()

                    if(!it.getString("tipo").isNullOrEmpty()){
                        tipo.add(it.toString())
                    }

                    else if(!it.getString("cantidad").isNullOrEmpty()){
                        cantidad.add(it.toString())
                    }

                    else if(!it.getString("nota").isNullOrEmpty()){
                        nota.add(it.toString())
                    }
                    finanzas!!.add(Finanza(tipo!!,cantidad!!,nota!!))

           }
                adaptador = FinanzasAdapter(this, finanzas)
                gridviewFinanzas.adapter = adaptador
        }
    }
}
