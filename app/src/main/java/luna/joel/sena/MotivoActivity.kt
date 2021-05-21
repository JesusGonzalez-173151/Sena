package luna.joel.sena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_motivo.*

class MotivoActivity : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    private var motivo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivo)

        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        viajar.setOnClickListener{
            val motivo = "viajar"
            guardarMotivo(motivo)
        }

        emprender.setOnClickListener{
            val motivo = "emprender"
            guardarMotivo(motivo)
        }

        otro.setOnClickListener{
            val motivo = "viajar"
            guardarMotivo(motivo)
        }

        ropa.setOnClickListener{
            val motivo = "ropa"
            guardarMotivo(motivo)
        }

    }

    private fun guardarMotivo(motivo: String){
        val motivacion = hashMapOf(
        "meta" to motivo
        )


        storage.collection("metas").add(motivacion).addOnSuccessListener {
            Toast.makeText(this,"Motivacion agregada", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }
    }
}