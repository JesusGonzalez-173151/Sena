package luna.joel.sena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresos_view.*
import kotlinx.android.synthetic.main.activity_finanzas.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tarjetas_view.*
import luna.joel.sena.Adaptadores.MetasAdapter
import luna.joel.sena.Objetos.Finanza
import luna.joel.sena.Objetos.Meta

class MainActivity : AppCompatActivity() {

    private var adaptador: MetasAdapter? = null
    private var metas = ArrayList<Meta>()

    var cantidad = 0.0F

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillFinanzas()

        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()
        //fillMetas()

        /*if(!logros.isEmpty()){

            adaptador = AdaptadorLogros(this,logros)
            gridview2.adapter = adaptador

        }*/

        btn_ingreso.setOnClickListener {
            val intent: Intent = Intent(this, Ingresos::class.java)
            startActivity(intent)
        }

        btn_egreso.setOnClickListener {
            val intent: Intent = Intent(this, Egresos::class.java)
            startActivity(intent)
        }

        senna_pro.setOnClickListener {
            val intent: Intent = Intent(this, TarjetaRegistro::class.java)
            startActivity(intent)
        }
    }


    fun fillFinanzas(){
        storage.collection("ingresos").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {

                    if(!it.getString("cantidad").isNullOrEmpty()){
                        it.getString("cantidad").toString().toInt()

                    }

                }

            }

        var porcentaje = (cantidad/150000)*100
        progress_ahorros.progress = porcentaje.toInt()

    }


    /*fun fillMetas(){
        var meta = ArrayList<String>()
        var cantidad = 0
        storage.collection("tarjetero").whereEqualTo("email", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach {

                    if(!it.getString("meta").isNullOrEmpty()){
                        meta.add("${it.getString("meta")!!}")


                    }
                    metas!!.add(Meta(meta!!,cantidad!!))
                }
                adaptador = MetasAdapter(this, metas)
                gridviewTarjetas.adapter = adaptador
            }
    }
*/
}












