package luna.joel.sena

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class FinanzasBar{

    /*companion object Ingresos{
        var cantidad: Int = 0
        private lateinit var storage: FirebaseFirestore
        private lateinit var usuario: FirebaseAuth

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

        }
    }*/
}