package luna.joel.sena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresos_view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tarjetas_view.*
import luna.joel.sena.Adaptadores.MetasAdapter
import luna.joel.sena.Objetos.Finanza
import luna.joel.sena.Objetos.Meta

class MainActivity : AppCompatActivity() {

    private var adaptador: MetasAdapter? = null
    private var metas = ArrayList<Meta>()

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    var cantidad = 0.0F


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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

}












