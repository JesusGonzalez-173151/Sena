package luna.joel.sena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_egresos.*
import kotlinx.android.synthetic.main.activity_ingresos.*

class Egresos : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egresos)

        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()

        btn_egresos.setOnClickListener {
            guardarEgresos()

        }
        btn_vistaEgresos.setOnClickListener {
            val intent: Intent= Intent(this, EgresosView::class.java)
            startActivity(intent)
        }
    }

    private fun guardarEgresos(){
        var tipoingreso = edit_egreso.text.toString()
        var cantidad = egreso_cantidad.text.toString()
        var nota = egr_nota.text.toString()

        val ingresos = hashMapOf(

            "cantidad" to cantidad,
            "nota" to nota,
            "tipo" to tipoingreso,
            "email" to usuario.currentUser?.email)


        storage.collection("egresos").add(ingresos).addOnSuccessListener {
            Toast.makeText(this,"Ingreso agregado", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }

    }



}