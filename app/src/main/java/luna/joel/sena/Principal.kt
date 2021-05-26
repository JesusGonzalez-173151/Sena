package luna.joel.sena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_egreso
import kotlinx.android.synthetic.main.activity_main.btn_ingreso
import kotlinx.android.synthetic.main.activity_main.senna_pro
import kotlinx.android.synthetic.main.activity_principal.*
import luna.joel.sena.Adaptadores.MetasAdapter
import luna.joel.sena.Objetos.Meta

class Principal : AppCompatActivity() {

    private var adaptador: MetasAdapter? = null
    private var metas = ArrayList<Meta>()


    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        fillMetas()

        storage = FirebaseFirestore.getInstance()

        usuario = FirebaseAuth.getInstance()


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



    fun fillMetas(){
        var meta = ArrayList<String>()

        storage.collection("tarjetero").whereEqualTo("email", usuario.currentUser?.email)
        .get()
        .addOnSuccessListener {
            it.forEach {

                if(!it.getString("meta").isNullOrEmpty()){
                    meta.add("${it.getString("meta")!!}")
                }
                metas!!.add(Meta(meta!!))
            }
            adaptador = MetasAdapter(this, metas)
            gridviewMetasPrincipal.adapter = adaptador
        }
    }
}