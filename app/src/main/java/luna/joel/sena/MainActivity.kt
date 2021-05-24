package luna.joel.sena

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adaptador: AdaptadorLogros? = null


    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth


    companion object{
        var logros = ArrayList<Logro>()
        var first = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logros = ArrayList()
        //Instanciar Firebase
        //Conexion BD
        storage = FirebaseFirestore.getInstance()
        //Conexion al ususarioGmail
        usuario = FirebaseAuth.getInstance()
        fillLogros()

        if(!logros.isEmpty()){

            adaptador = AdaptadorLogros(this,logros)
            gridview2.adapter = adaptador

        }

        btn_ingreso.setOnClickListener {
            val intent: Intent= Intent(this, Ingresos::class.java)
            startActivity(intent)
        }

        btn_egreso.setOnClickListener {
            val intent: Intent= Intent(this, Egresos::class.java)
            startActivity(intent)
        }

        senna_pro.setOnClickListener {
            val intent: Intent= Intent(this, TarjetaRegistro::class.java)
            startActivity(intent)
        }
    }

    fun fillLogros(){
        storage.collection("metas")
            .whereEqualTo("correo", usuario.currentUser?.email)
            .get()
            .addOnSuccessListener {
                it.forEach{
                    var cantidad = ""
                    if(it.getString("meta")!= null){
                        cantidad = "0"
                    }
                    logros!!.add(Logro(it.getString("meta")!!, cantidad))
                    }
                adaptador= AdaptadorLogros(this, logros)
                gridview2.adapter= adaptador
                }
    }

    private class AdaptadorLogros: BaseAdapter {
        var logros = ArrayList<Logro>()
        var context: Context? = null

        constructor(contexto: Context, logros: ArrayList<Logro>){
            this.context = contexto
            this.logros = logros
        }

        override fun getCount(): Int {
            return logros.size
        }

        override fun getItem(p0: Int): Any {
            return logros[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var logross = logros[p0]
            var inflador = LayoutInflater.from(this.context)
            var vista = inflador.inflate(R.layout.metas_views, null)

            val nombre: TextView = vista.findViewById(R.id.metaNombre)

            nombre.setText(logross.meta)

            return vista
        }
    }
}
