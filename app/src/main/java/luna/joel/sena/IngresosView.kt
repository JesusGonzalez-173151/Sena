package luna.joel.sena


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresos_view.*
import kotlinx.android.synthetic.main.activity_ingresos_view.*
import luna.joel.sena.Adaptadores.FinanzasAdapter

import luna.joel.sena.Objetos.Finanza


class IngresosView : AppCompatActivity() {

    var adaptador: FinanzasAdapter? = null
    var ingresos =  ArrayList<Finanza>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresos_view)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        fillFinanzas()
        if(!ingresos.isEmpty()) {
            adaptador = FinanzasAdapter(this, ingresos)
            gridviewIngresos.adapter = adaptador
        }
    }

    fun fillFinanzas(){
        var tipo = ArrayList<String>()
        var cantidad = ArrayList<String>()
        var nota = ArrayList<String>()

        storage.collection("ingresos").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {

                    if(!it.getString("tipo").isNullOrEmpty()){
                        tipo.add("${it.getString("tipo")}")
                        cantidad.add("${it.getString("cantidad")}")
                        nota.add("${it.getString("nota")}")
                    }

                    ingresos!!.add(Finanza(tipo!!,cantidad!!,nota!!))

                }

                adaptador = FinanzasAdapter(this, ingresos)
                gridviewIngresos.adapter = adaptador

            }
    }
}