package luna.joel.sena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresos_view.*
import kotlinx.android.synthetic.main.activity_finanzas.*
import kotlinx.android.synthetic.main.activity_finanzas.gridviewFinanzas

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
            gridviewEgresos.adapter = adaptador
        }
    }

    fun fillFinanzas(){
        var tipo = ArrayList<String>()
        var cantidad = ArrayList<String>()
        var nota = ArrayList<String>()

        storage.collection("egresos").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {

                    if(!it.getString("tipo").isNullOrEmpty()){
                        tipo.add("${it.getString("tipo")}")
                        cantidad.add("${it.getString("cantidad")}")
                        nota.add("${it.getString("nota")}")
                    }

                    egresos!!.add(Finanza(tipo!!,cantidad!!,nota!!))

                }

                adaptador = FinanzasAdapter(this, egresos)
                gridviewEgresos.adapter = adaptador

            }
    }
}