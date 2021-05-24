package luna.joel.sena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_finanzas.*
import kotlinx.android.synthetic.main.activity_tarjetas_view.*

class TarjetasView : AppCompatActivity() {

    var adaptador: TarjetaAdapter? = null
    var tarjeta =  ArrayList<Tarjeta>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarjetas_view)

        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        fillTarjetas()
        if(!tarjeta.isEmpty()) {
            adaptador = TarjetaAdapter(this, tarjeta)
            gridviewTarjetas.adapter = adaptador
        }
    }

    fun fillTarjetas(){
        var fecha = ArrayList<String>()
        var nombre = ArrayList<String>()
        var tipo = ArrayList<String>()
        var numero = ArrayList<String>()

        storage.collection("tarjetero").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {

                    if(!it.getString("nombreTitular").isNullOrEmpty()){
                        fecha.add("${it.getString("fechaExp")!!}")
                        nombre.add("${it.getString("nombreTitular")!!}")
                        tipo.add("${it.getString("tipoTarjeta")!!}")
                        numero.add("${it.getString("numeroTarjeta")!!}")
                    }
                    tarjeta!!.add(Tarjeta(fecha!!,nombre!!,tipo!!,numero!!))
                }
                adaptador = TarjetaAdapter(this, tarjeta)
                gridviewTarjetas.adapter = adaptador
            }
    }
}