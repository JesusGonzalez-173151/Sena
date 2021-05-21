package luna.joel.sena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_seleccionar_login.*

class SeleccionarLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccionar_login)

        

        btn_correo.setOnClickListener{
            val intent: Intent= Intent(this, EmailLogin::class.java)
            startActivity(intent)
        }
    }
}