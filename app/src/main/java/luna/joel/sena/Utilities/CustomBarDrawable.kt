package luna.joel.sena.Utilities

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import luna.joel.sena.Objetos.Finanza
import luna.joel.sena.R

class CustomBarDrawable: Drawable {

    var coordenadas: RectF? = null
    var context: Context? = null
    var finanzas: Finanza? = null

    constructor(context: Context, finanzas: Finanza){

        this.context = context
        this.finanzas=finanzas
    }

    override fun draw(p0: Canvas) {
        val fondo: Paint = Paint()
        fondo.style = Paint.Style.FILL
        fondo.isAntiAlias = true
        fondo.color = context?.resources?.getColor(R.color.gray)?: R.color.gray
        val ancho: Float = (p0.width - 10).toFloat()
        val alto: Float =  (p0.height - 10).toFloat()

        coordenadas = RectF(0.0F, 0.0F, ancho, alto)

        p0.drawRect(coordenadas!!, fondo)

       /* if(this.finanzas !=null){
            val porcentaje: Double = this.finanzas!!.porcentaje * (p0.width -10)/100
            var coordenadas2 = RectF(0.0F , 0.0F, porcentaje.toFloat(), alto)

            var seccion: Paint = Paint()
            seccion.style= Paint.Style.FILL
            seccion.isAntiAlias = true
            seccion.color = ContextCompat.getColor(this.context!!, finanzas!!.color)

            p0.drawRect(coordenadas2!!,seccion)
        }
*/

    }

    override fun setAlpha(p0: Int) {

    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

    override fun setColorFilter(p0: ColorFilter?) {

    }

}